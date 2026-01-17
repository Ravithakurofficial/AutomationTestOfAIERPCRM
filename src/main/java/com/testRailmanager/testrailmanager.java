package com.testRailmanager;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;

public class testrailmanager {
    public static String Test_Run_ID = "13";
    public static String url = "https://webaierpcrm.testrail.io/";
    public static String Test_Rail_UserName = "Thakurravikumar400@gmail.com";
    public static String Test_Rail_Password = "sHecMwCxvG.TKmkhc1.q-oAOlQ/gt0wUq1Lm.oC3r";
    public static int Test_case_Pass = 1;
    public static int Test_case_Fail = 5;

    public static void addresult(String TestCaseId,int status, String error){
        String test_id = Test_Run_ID;
        APIClient client = new APIClient(url);
        client.setUser(Test_Rail_UserName);
        client.setPassword(Test_Rail_Password);
        HashMap<String,Object> data = new HashMap<>();
        data.put("status_id",status);
        data.put("comment",error);
        try{
            client.sendPost("add_result_for_case/"+test_id+"/"+TestCaseId,data);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (APIException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




}
