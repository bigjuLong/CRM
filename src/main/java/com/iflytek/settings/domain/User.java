package com.iflytek.settings.domain;

/**
 * @author congchen6
 * @date 2021-12-02 10:40
 */
public class User {
    /**
     * 关于字符串表示的日期及时间，市场上有
     * 两种常用的方式：1.日期：年月日  yyyy-MM-dd  10位字符串
     * 2.日期+时间 年月日时分秒  19位字符串  yyyy-MM-dd  HH:mm:ss
     */
    private String id;              //编号 主键
    private String loginAct;        //登录账号
    private String name;            //用户真实姓名
    private String loginPwd;        //登录密码
    private String email;           //邮箱
    private String expireTime;      //失效时间   19位
    private String lockState;       //锁定状态 0：表示锁定 1：表示启用
    private String deptNo;          //部门编号
    private String allowIps;        //允许访问的ip地址
    private String createTime;      //创建时间    19位
    private String createBy;        //创建人
    private String editTime;        //修改时间    19位
    private String editBy;          //修改人
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginAct() {
        return loginAct;
    }

    public void setLoginAct(String loginAct) {
        this.loginAct = loginAct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getLockState() {
        return lockState;
    }

    public void setLockState(String lockState) {
        this.lockState = lockState;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptno(String deptno) {
        this.deptNo = deptno;
    }

    public String getAllowIps() {
        return allowIps;
    }

    public void setAllowIps(String allowIps) {
        this.allowIps = allowIps;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy;
    }
}