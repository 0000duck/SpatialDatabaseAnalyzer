/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import ui.Util;

/**
 *
 * @author Raffan
 */
public class Road {
    private Integer id;
    private String lineArId;
    private String fullName;
    private String rtType;
    private String mtfCc;
    private byte[] geometry;
    private String asText;

    public Road() {
    }

    public Road(Integer id, String lineArId, String fullName, String rtType, String mtfCc, byte[] geometry, String asText) {
        this.id = id;
        this.lineArId = lineArId;
        this.fullName = fullName;
        this.rtType = rtType;
        this.mtfCc = mtfCc;
        this.geometry = geometry;
        this.asText = asText;
    }

    public void printInfo()
    {
        System.out.println(getPrintString());
    }
    
    public String getPrintString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(""+id);
        sb.append("\t"+lineArId);
        sb.append("\t"+fullName);
        for(int i=0; i<40-fullName.length(); i++){
            sb.append(" ");
        }
        sb.append(""+rtType);
        //sb.append(",\t\t\t"+rtType);
        sb.append("\t"+mtfCc);
        //sb.append("\t"+Util.byteToString(geometry));
        sb.append("\t"+asText);
        sb.append("\n");
        return sb.toString();
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLineArId() {
        return lineArId;
    }

    public void setLineArId(String lineArId) {
        this.lineArId = lineArId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRtType() {
        return rtType;
    }

    public void setRtType(String rtType) {
        this.rtType = rtType;
    }

    public String getMtfCc() {
        return mtfCc;
    }

    public void setMtfCc(String mtfCc) {
        this.mtfCc = mtfCc;
    }

    public byte[] getGeometry() {
        return geometry;
    }

    public void setGeometry(byte[] geometry) {
        this.geometry = geometry;
    }

    public String getAsText() {
        return asText;
    }

    public void setAsText(String asText) {
        this.asText = asText;
    }
    
}
