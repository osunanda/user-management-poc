package com.usermanagementservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public class AppMetadata {

    private List<OrgId> orgIds;

    public List<OrgId> getOrgIds() {
        return orgIds;
    }

    public void setOrgIds(List<OrgId> orgIds) {
        this.orgIds = orgIds;
    }
}
