package com.skysport.inerfaces.bean.system;import com.skysport.core.bean.SelectItem;/** * */public class SexInfo  extends SelectItem {    private String id;    private String sexId;    private String sexName;    private String sexFullname;    private String enSexName;    private String enSexFullname;    private int delFlag;    private String remark;    private String updateTime;    public String getId() {        return id;    }    public void setId(String id) {        this.id = id;    }    public String getSexId() {        return sexId;    }    public void setSexId(String sexId) {        this.sexId = sexId;    }    public String getSexName() {        return sexName;    }    public void setSexName(String sexName) {        this.sexName = sexName;    }    public String getSexFullname() {        return sexFullname;    }    public void setSexFullname(String sexFullname) {        this.sexFullname = sexFullname;    }    public String getEnSexName() {        return enSexName;    }    public void setEnSexName(String enSexName) {        this.enSexName = enSexName;    }    public String getEnSexFullname() {        return enSexFullname;    }    public void setEnSexFullname(String enSexFullname) {        this.enSexFullname = enSexFullname;    }    public int getDelFlag() {        return delFlag;    }    public void setDelFlag(int delFlag) {        this.delFlag = delFlag;    }    public String getRemark() {        return remark;    }    public void setRemark(String remark) {        this.remark = remark;    }    public String getUpdateTime() {        return updateTime;    }    public void setUpdateTime(String updateTime) {        this.updateTime = updateTime;    }}