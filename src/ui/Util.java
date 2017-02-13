/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author Raffan
 */
public class Util {
    public static String byteToString(byte[] bytes)
    {
        if(bytes==null || bytes.length==0){
            return "";
        }
        StringBuilder sb = new StringBuilder(bytes.length * 4);
        boolean spaceNeeded = false;
        for(byte b: bytes){
            if(spaceNeeded){
                sb.append(" ");
            }
            sb.append(String.format("%02x", b&0xff));
            spaceNeeded = true;
        }
        return sb.toString();
    }
}
