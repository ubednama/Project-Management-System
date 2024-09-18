package com.ubednama.controller;

import com.ubednama.DTO.IssueDetailsDTO;
import com.ubednama.model.Issue;
import com.ubednama.model.User;
import com.ubednama.request.IssueRequest;
import com.ubednama.response.MessageResponse;
import com.ubednama.service.IssueService;
import com.ubednama.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issues")
public class IssueController {
    @Autowired
    private IssueService issueService;

    @Autowired
    private UserService userService;

    @GetMapping("/{issueId}")
    public ResponseEntity<Issue> getIssueById(@PathVariable Long issueId) throws Exception {
        return ResponseEntity.ok(issueService.getIssueById(issueId));
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Issue>> getIssueByProjectId(@PathVariable Long projectId) throws Exception {
        return ResponseEntity.ok(issueService.getIssueByProjectId(projectId));
    }

    @PostMapping
    public ResponseEntity<IssueDetailsDTO> createIssue(@RequestBody IssueRequest issue,
                                                       @RequestHeader("Authorization") String token) throws Exception {
        System.out.println("issue......." + issue);
        User tokenUser = userService.findUserProfileByJwt(token);
        User user = userService.findUserById(tokenUser.getId());

        Issue createdIssue = issueService.createIssue(issue, tokenUser);
        IssueDetailsDTO issueDetailsDTO = new IssueDetailsDTO();
        issueDetailsDTO.setDescription(createdIssue.getDescription());
        issueDetailsDTO.setDueDate(createdIssue.getDueDate());
        issueDetailsDTO.setId(createdIssue.getId());
        issueDetailsDTO.setPriority(createdIssue.getPriority());
        issueDetailsDTO.setProject(createdIssue.getProject());
        issueDetailsDTO.setStatus(createdIssue.getStatus());
        issueDetailsDTO.setTitle(createdIssue.getTitle());
        issueDetailsDTO.setTags(createdIssue.getTags());
        issueDetailsDTO.setAssignee(createdIssue.getAssignee());

        return ResponseEntity.ok(issueDetailsDTO);
    }

    @DeleteMapping("/{issueId}")
    public ResponseEntity<MessageResponse> deleteIssue(@PathVariable Long issueId,
                                                       @RequestHeader("Authorization") String token) throws Exception {
        User user = userService.findUserProfileByJwt(token);
        issueService.deleteIssue(issueId, user.getId());

        MessageResponse res = new MessageResponse();
        res.setMessage("Issue deleted");

        return ResponseEntity.ok(res);
    }

    @PutMapping("/{issueId}/assignee/{userId}")
    public ResponseEntity<Issue> addUserToIssue(@PathVariable Long issueId, @PathVariable Long userId) throws Exception {
        Issue issue = issueService.addUserToIssue(issueId, userId);

        return ResponseEntity.ok(issue);
    }

    @PutMapping("/{issueId}/status/{status}")
    public ResponseEntity<Issue> updateIssueStatus(@PathVariable String status, @PathVariable Long issueId) throws Exception {
        Issue issue = issueService.updateStatus(issueId, status);
        return ResponseEntity.ok(issue);
    }
}
