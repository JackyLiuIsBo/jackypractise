/**
 * Project: o2o-ad-photonweb-service
 *
 * File Created at Feb 28, 2020
 * $Id$
 *
 * Copyright 2008 Alibaba.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Alibaba Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alibaba.com.
 */
package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * TODO Comment of AptitudeAuditQueryVO
 *
 * @author wangtingbang
 */
public class AptitudeAuditQueryVO {

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户PID
     */
    private String userPid;
    /**
     * 用户行业类目ID
     */
    private String userCategoryId;

    /**
     * 资质名称
     */
    private String title;
    /**
     * 用户资质类型ID
     */
    private Long aptitudeId;
    /**
     * 资质类型
     */
    private Integer aptitudeTypeId;
    /**
     * 审核状态
     */
    private Byte auditState;

    /**
     * 更新时间-开始
     */
    private String start;

    /**
     * 更新时间-结束
     */
    private String end;

    /**
     * 审核时间-开始
     */
    private String auditTimeStart;

    /**
     * 审核时间-结束
     */
    private String auditTimeEnd;
    /**
     * 审核人
     */
    private String auditOperator;

    private Byte deleteFlag;

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
        this.userName = userName;
    }

    public String getUserPid() {
        return userPid;
    }

    public void setUserPid(String userPid) {
        this.userPid = userPid;
    }

    public String getUserCategoryId() {
        return userCategoryId;
    }

    public void setUserCategoryId(String userCategoryId) {
        this.userCategoryId = userCategoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAptitudeId() {
        return aptitudeId;
    }

    public void setAptitudeId(Long aptitudeId) {
        this.aptitudeId = aptitudeId;
    }

    public Integer getAptitudeTypeId() {
        return aptitudeTypeId;
    }

    public void setAptitudeTypeId(Integer aptitudeTypeId) {
        this.aptitudeTypeId = aptitudeTypeId;
    }

    public Byte getAuditState() {
        return auditState;
    }

    public void setAuditState(Byte auditState) {
        this.auditState = auditState;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getAuditTimeStart() {
        return auditTimeStart;
    }

    public void setAuditTimeStart(String auditTimeStart) {
        this.auditTimeStart = auditTimeStart;
    }

    public String getAuditTimeEnd() {
        return auditTimeEnd;
    }

    public void setAuditTimeEnd(String auditTimeEnd) {
        this.auditTimeEnd = auditTimeEnd;
    }

    public String getAuditOperator() {
        return auditOperator;
    }

    public void setAuditOperator(String auditOperator) {
        this.auditOperator = auditOperator;
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public static void main(String[] args) {
        String[] words = {"hello", "world"};
        List<String[]> collect = Arrays.stream(words).map(t -> t.split("")).distinct().collect(Collectors.toList());
        collect.stream().flatMap(t -> Arrays.stream(t).map(s ->s.split("")));
        System.out.println(collect);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
            numbers1.stream()
                .flatMap(i -> numbers2.stream()
                    .map(j -> new int[] {i, j})
                )
                .collect(toList());
        numbers1.stream().map(i -> numbers2.stream().map(j -> new int[] {i, j})).collect(
            toList());
        System.out.println(numbers1);
    }
}
