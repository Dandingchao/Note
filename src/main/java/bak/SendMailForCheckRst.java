/*
import java.util.*;

public class mail {
    public int sendmail(ComOneCheckTaskResult tmp) {
        final String subtitle="组件商用工具检测通告邮件";//邮件标题
        IDesignCheckServ dccheck=new DesignCheckServImpl();//通过comonechecktaskresult中的pkg，com，branch信息查询对应的dc检测数据。
        Map<String,Object> dccheckrst=new HashMap<>();
        dccheckrst=dccheck.getDcDetailData("所有",tmp.getPkg(),tmp.getCom(),tmp.getBranch(),
                "所有","所有"
                ,"所有","所有","所有","1","20");//将查询结果写到map中,具体使用请查看相关函数。
        System.out.println("dccheckrst"+dccheckrst.size());
        Set<String> para= dccheckrst.keySet();
        for (String para1:para
        ) {
            System.out.print(para1+":");
            System.out.println(dccheckrst.get(para1));
        }
        List<Map<String, String>> tmpMapList= new ArrayList<Map<String, String>>();//创建数组获取查询到的信息队列
        tmpMapList= (ArrayList<Map<String, String>>) dccheckrst.get("rows");
        System.out.println("tmpMapList:size"+tmpMapList.size());
        int check=0;//确认未修订
        int uncheck=0;//未确认
        Iterator<Map<String,String>> it=tmpMapList.iterator();//迭代器迭代遍历结果列表，将所有的未修订数据和确认未修订数据相加。
        while (it.hasNext()){
            Map<String,String> da=it.next();
            check=check+ Integer.parseInt(da.get("2"));
            uncheck=uncheck+Integer.parseInt(da.get("1"));

        }

        StringBuilder content1 = new StringBuilder("<html><head></head><body><h2>商用工具一键验证结果反馈</h2>");//邮件正文
        content1.append("<br/>");
        content1.append("<h3>任务id:" + tmp.getTaskId() + "<h3/>");
        content1.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content1.append("<tr style=\"background-color: #fffff; color:#000000\">" +
                "<th>申请人</th>" +
                "<th>项目名称</th>" +
                "<th>商用工具检查结果</th>" +
                "<th>Dc检查</th>" +
                "<th>单词拼写检查</th>" +
                "<th>检查类型</th></tr>");
        content1.append("<tr>");
        content1.append("<td>" + tmp.getProposer() + "</td>");//申请人
        content1.append("<td>" + tmp.getProject() + "</td>");//项目名称
        content1.append("<td>" +
                "<a href=\"http://ci.ruijie.net:8081/RGCC/aProjectCov.jsp?project=onekeyCheck"
                + "&product="
                + tmp.getTaskId()
                + "&ruleNum=所有&baseAdd=false"
                +tmp.getCovRst()
                +"\"> "
                + tmp.getCovRst() + " </a>" + "</td>");//商用工具检查结果

        content1.append("<td>" +
                "<a href=\"http://ci.ruijie.net:8081/RGCC/mPrjUncheckAll.jsp?"
                + "easyui=true/pkg="
                + tmp.getPkg()
                + "/com="
                +tmp.getCom()
                +"/branch="
                +tmp.getBranch()
                +"\"> "
                + "未确认:"+uncheck+",确认未修订:"+check
                //+"查看"
                + " </a>" + "</td>");//DC检测结果

        content1.append("<td>" +
                "<a href=\"http://ci.ruijie.net:8081/RGCC/cppSpellBugAll.jsp?"
                + "easyui=true/project="
                + tmp.getProject()
                + "_onekey/pkg="
                +tmp.getPkg()
                +"/com="
                +tmp.getCom()
                + "/branch="
                +tmp.getBranch()
                +"\"> "
                + "查看" + " </a>" + "</td>");//拼写检测结果


        content1.append("<td>" + tmp.getTools() + "</td>");//检查类型
        content1.append("</tr>");

        final String content=content1.toString();//将结果转换为string字符串。

        String usermailname = new UserInfoServ().getNamesByNameCn(tmp.getProposer());//获取收件人账号
        //String mailto = usermailname + "@ruijie.com.cn";
        String mailto = "youpengchao" + "@ruijie.com.cn";//测试版将youpengchao的账号作为收信测试账号
        String mailcc = null;//没有抄送给其他对象

        SendMail.mailSendByContent(subtitle, content, mailto, mailcc);
        System.out.println("send success");
        return 1;
    }

    public int sendmailtest(ComOneCheckTaskResult tmp) {
        StringBuilder content1 = new StringBuilder("<html><head></head><body><h2>商用工具一键验证结果反馈</h2>");
        content1.append("<br/>");
        content1.append("<h3>任务id:" + tmp.getTaskId() + "<h3/>");
        content1.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content1.append("<tr style=\"background-color: #fffff; color:#000000\"><th>申请人</th><th>项目名称</th><th>商用工具检查结果</th><th>检查类型</th></tr>");
        content1.append("<tr>");
        content1.append("<td>" + tmp.getProposer() + "</td>");
        content1.append("<td>" + tmp.getProject() + "</td>");
        content1.append("<td>" +
                "<a href=\"http://ci.ruijie.net:8081/RGCC/aProjectCov.jsp?project=onekeyCheck"
                + "&product="
                + tmp.getTaskId()
                + "&ruleNum=所有&baseAdd=false\"> " + tmp.getCovRst() + " </a>" + "</td>");
        content1.append("<td>" + tmp.getTools() + "</td>");
        content1.append("</tr>");

        String usermailname = new UserInfoServ().getNamesByNameCn(tmp.getProposer());
        //String mailto = usermailname + "@ruijie.com.cn";
        String mailto ="youpengchao@ruijie.com.cn";
        String mailcc = null;
        SendMail.mailSendByContent("组件商用工具检测通告邮件", content1.toString(), mailto, mailcc);
        System.out.println("send success");
        return 1;
    }


    public int testsendmail() {
        StringBuilder content1 = new StringBuilder("<html><head></head><body><h2>商用工具一键验证结果反馈</h2>");
        String content = "申请人:"//+tmp.getProposer()
                + "\n" + "项目名称："//+tmp.getProject()
                + "\n" + "商用工具检查结果："//+tmp.getCovRst()
                + "\n" + "检查类型:" + "暂时不知道去哪里找"
                + "\n" + "url:" + "<a href='https://www.baidu.com'>baidu</a>"
                + "<p><p/>"

                + "<a href=\"http://ci.ruijie.net:8081/RGCC/aProjectCov.jsp?project=onekeyCheck"
                + "&product="
                //+ taskid
                + "&ruleNum=所有&baseAdd=false\"> " + "查询结果的连接 </a>"
                + "<br/>";


        content1.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content1.append("<tr style=\"background-color: #fffff; color:#000000\"><th>申请人</th><th>项目名称</th><th>商用工具检查结果</th><th>检查类型</th></tr>");
        content1.append("<tr>");
        content1.append("<td>" + "<a href='https://www.baidu.com'>baidu</a>" + "</td>");
        content1.append("<td>" + "data.column2" + "</td>");
        content1.append("<td>" + "data.column3" + "</td>");
        content1.append("<td>" + "data.column3" + "</td>");
        content1.append("</tr>");
        content1.append("</table>");
        content1.append("<h3>description</h3>");
        content1.append("</body></html>");

        content1.append("<br/>");

        String mailto = "youpengchao@ruijie.com.cn";
        String mailcc = null;
        SendMail.mailSendByContent("组件商用工具检测通告邮件", content1.toString(), mailto, mailcc);
        System.out.println("send success");
        return 1;
    }
    private void sendMailForCheck(ComOneCheckTaskResult tmp) {
        StringBuilder content1 = new StringBuilder("<html><head></head><body><h2>商用工具一键验证结果反馈</h2>");
        content1.append("<br/>");
        content1.append("<h3>任务id:" + tmp.getTaskId() + "<h3/>");
        content1.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        content1.append("<tr style=\"background-color: #fffff; color:#000000\"><th>申请人</th><th>项目名称</th><th>商用工具检查结果</th><th>检查类型</th></tr>");
        content1.append("<tr>");
        content1.append("<td>" + tmp.getProposer() + "</td>");
        content1.append("<td>" + tmp.getProject() + "</td>");
        content1.append("<td>" +
                "<a href=\"http://ci.ruijie.net:8081/RGCC/aProjectCov.jsp?project=onekeyCheck"
                + "&product="
                + tmp.getTaskId()
                + "&ruleNum=所有&baseAdd=false\"> " + tmp.getCovRst() + " </a>" + "</td>");
        content1.append("<td>" + tmp.getTools() + "</td>");
        content1.append("</tr>");
        String usermailname = new UserInfoServ().getNamesByNameCn(tmp.getProposer());
        usermailname = "youpengchao";
        String mailto = usermailname + "@ruijie.com.cn";
        String mailcc = null;
        SendMail.mailSendByContent("商用工具检测反馈邮件", content1.toString(), mailto, mailcc);
        System.out.println("send success");
    }
}*/
