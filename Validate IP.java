/*
Given a string IP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.

A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0" are valid IPv4 addresses but "192.168.01.1", while "192.168.1.00" and "192.168@1.1" are invalid IPv4 addresses.

A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:

    1 <= xi.length <= 4
    xi is a hexadecimal string which may contain digits, lower-case English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
    Leading zeros are allowed in xi.

*/

class Solution {
    public String validIPAddress(String IP) {
        String[] temp = IP.split(":");
        if(IP.contains(".") && IPv4(IP) == true) return "IPv4";
        if(IP.contains(":") && IPv6(IP) == true) return "IPv6";
        return "Neither";
        
    }
    public boolean IPv4(String IP){
        
        String [] temp = IP.split("\\.");
        
        if(temp.length != 4 || IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') return false;
        
        for(String s : temp){
            if(s.length() > 3 || !(s.matches("[0-9]+")) || (s.length() > 1 && s.charAt(0) == '0') || Integer.parseInt(s) > 255){
                return false;
            }
        }
        return true;
    }
    
    public boolean IPv6(String IP){
        
        String [] temp = IP.split(":");
        
        if(temp.length != 8 || IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') return false;
        
        for(String s : temp)
            if(s.length() < 1 || s.length() > 4 || !(s.matches("[A-Fa-f0-9]+"))) return false;
        return true;
    }
}
