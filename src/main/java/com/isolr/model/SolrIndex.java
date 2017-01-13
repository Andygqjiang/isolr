package com.isolr.model;

/**
 * @author Andy
 * @since 2016/8/31 0031.
 */
public class SolrIndex {

    private Long bid;

    private Long companyId;

    private Long userId;

    private String userName;

    private Long createTime;

    private String telephone;

    private String content;

    public Long getBid() {
        return bid;
    }

    public void setBid(Long id) {
        this.bid = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SolrIndex{" +
                "bid=" + bid +
                ", companyId=" + companyId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", telephone='" + getTelephone() + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
