package com.ubednama.service;

import com.ubednama.model.Issue;
import com.ubednama.model.User;
import com.ubednama.request.IssueRequest;

import java.util.List;

public interface IssueService {
    Issue getIssueById(Long issueId) throws Exception;

    List<Issue> getIssueByProjectId(Long projectId) throws Exception;

    Issue createIssue(IssueRequest issue, User user) throws Exception;

    void deleteIssue(Long issueId, Long userId) throws Exception;

    Issue addUserToIssue(Long issueId, Long userId) throws Exception;

    Issue updateStatus(Long issueId, String status) throws Exception;

//    Issue getIssue
}
