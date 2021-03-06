package com.caler.zkl.openpsd.bean;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.id
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.member_level_id
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    private Long memberLevelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.username
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.password
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.nickname
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    private String nickname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.phone
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.status
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.create_time
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.gender
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    private Integer gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.birthday
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    private Date birthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.city
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    private String city;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.job
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    private String job;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.company_id
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    private Long companyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.email
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.last_login_time
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    private Date lastLoginTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.note
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    private String note;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table member
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.id
     *
     * @return the value of member.id
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.id
     *
     * @param id the value for member.id
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.member_level_id
     *
     * @return the value of member.member_level_id
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public Long getMemberLevelId() {
        return memberLevelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.member_level_id
     *
     * @param memberLevelId the value for member.member_level_id
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public void setMemberLevelId(Long memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.username
     *
     * @return the value of member.username
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.username
     *
     * @param username the value for member.username
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.password
     *
     * @return the value of member.password
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.password
     *
     * @param password the value for member.password
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.nickname
     *
     * @return the value of member.nickname
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.nickname
     *
     * @param nickname the value for member.nickname
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.phone
     *
     * @return the value of member.phone
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.phone
     *
     * @param phone the value for member.phone
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.status
     *
     * @return the value of member.status
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.status
     *
     * @param status the value for member.status
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.create_time
     *
     * @return the value of member.create_time
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.create_time
     *
     * @param createTime the value for member.create_time
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.gender
     *
     * @return the value of member.gender
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.gender
     *
     * @param gender the value for member.gender
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.birthday
     *
     * @return the value of member.birthday
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.birthday
     *
     * @param birthday the value for member.birthday
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.city
     *
     * @return the value of member.city
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.city
     *
     * @param city the value for member.city
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.job
     *
     * @return the value of member.job
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public String getJob() {
        return job;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.job
     *
     * @param job the value for member.job
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.company_id
     *
     * @return the value of member.company_id
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.company_id
     *
     * @param companyId the value for member.company_id
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.email
     *
     * @return the value of member.email
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.email
     *
     * @param email the value for member.email
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.last_login_time
     *
     * @return the value of member.last_login_time
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.last_login_time
     *
     * @param lastLoginTime the value for member.last_login_time
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.note
     *
     * @return the value of member.note
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.note
     *
     * @param note the value for member.note
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member
     *
     * @mbg.generated Fri May 01 10:54:30 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberLevelId=").append(memberLevelId);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", phone=").append(phone);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", city=").append(city);
        sb.append(", job=").append(job);
        sb.append(", companyId=").append(companyId);
        sb.append(", email=").append(email);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", note=").append(note);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}