package com.actio.app.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.actio.app.model.IssueStatus;


@ApplicationScoped
public class IssueStatusRepository {

    @Inject
    private EntityManager em;

    public IssueStatus findById(Long id) {
        return em.find(IssueStatus.class, id);
    }

    public List<IssueStatus> findAllOrderedByTitle() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<IssueStatus> criteria = cb.createQuery(IssueStatus.class);
        Root<IssueStatus> issueStatus = criteria.from(IssueStatus.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
        criteria.select(issueStatus).orderBy(cb.asc(issueStatus.get("title")));
        return em.createQuery(criteria).getResultList();
    }
 }