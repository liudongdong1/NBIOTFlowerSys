package com.ldd.flower.common;

import com.ldd.flower.entity.User;

import java.util.*;
import java.util.logging.Logger;

/**
 * @Author liudongdong
 * @Date Created in 18:55 2019/9/6
 * @Description
 */
public class UserInitData {
    private static Logger logger=Logger.getLogger("UserInitData");
    public static final String password="123456";
    public static final String nametext="杨舒涵, 阚澳, 李佳泽, 程友琪, 贾斯涵, 张园博, 刘凤魁, 张莉彬, 赵雅欣, 陈赫元, 王博, 李硕, 潘正平, 周植, 吴严, 乔雅婷, 邝孝伟, 许嘉良, 张峻伟, 赵剑鹏, 李嘉寅, 王奕, 王中禹, 牟乔旭, 刘冬冬, 刘家运, 刘姝秀, 邵婧雯, 张爱琳, 安琳, 宋士增, 王乂冉, 杨晨, 钟若涵, 冯时, 李海亮, 刘宇涵, 王碧琳, 杨文哲, 曾夫为, 刘思佳, 路爱同, 俞圣亮, 孙博文, 许晶航, 郑贺, 贾金鑫, 刘嘉欣, 刘思霏, 张斌, 胡佩威, 王铭熙, 周雅婷, 刘锴, 辛逸飞, 逯晨阳, 成骏昕, 倪畅, 纪名岳, 魏秀坤, 张嘉凌, 谷云涵, 梁小凤, 普穷, 杨雨欣, 郭泽洋, 聂晨飞, 李良, 梁琪, 栾东明, 陈建玮, 王睿, 杨靖泽, 张淑敏, 郭欣宇, 蒋卓宸, 张岚滔, 阚博文, 文一霞, 张东升, 如斯太木·艾麦尔, 王历昊, 于昆平, 张磊, 张璇, 宋莹莹, 周福来, 李阳, 贾宝田, 黄秋阳";
    public static String role[]={"管理员","用户"};
    public static String decription[]={"该优秀员工勤恳务实，善于学习，对本职工作兢兢业业，注重个人成长;工作成绩进 步大， 业绩发展迅速， 或有效改进自己的工作方式， 从而在工作中收到良好效果； 悟性较强，能很快适应新的岗位，在新的业务区域可以立即开展工作；能随时根 据工作需要调整工作方法和端正心态，不断反思自己，注重个人成长；能在业余 时间精专业务知识，提高工作能力;悟性高，工作认真勤奋，吃苦耐劳，进步很 快，在新人中起到了榜样作用",
              "有良好的个人形象和素养，专业技能或业务水平优秀，为公司业务创造更 多机会和效益，受公司客户及合作企业好评，为公司创造出较好的企业效益或社 会效益;工作认真负责，积极主动，服从整体安排，爱岗敬业，乐于助人，与同 事相处融洽，业务知识扎实，业务水平优秀，能带动东区的给为同事积极工作， 胜任东区大区经理工作;工作出色，业务熟悉，为我们成立起榜样。",
              "办事方法有改进，工作有进步，该优秀员工做事情踏踏实实、做人本分，能 够虚心接受市场招商经理的建议，努力学习不足之处；大力开发所负责区域的空 白品种，并积极和经理进行各种环节的沟通；在 XX 年 X 月份进步异常迅速；对 待工作兢兢业业，处处为公司考虑，不记个人得失;",
              "此同事在工作上勤勤恳恳，任劳任怨，认真负责，业务水平也在学习中不断提高， 关心同事，非常值得大家学习，新晋社会如此努力难能可贵",
              "工作认真负责，积极主动，服从整体安排，爱岗敬业，业务知识扎实， 业务水平优秀，与北区各位经理相处融洽，树立榜样，胜任北区大区经理工作; 人品端正、做事塌实、行为规范、对待所负责区域进行有效指导，并提出建设性 意见;高度敬业，表现出色",
              "工作热情高;人品端正、德行优良、自身修养较高、对待客户诚信；对待 工作严谨、处处为公司考虑，能够虚心接受同事给予的建议并改正；学习进步较 快、受到大多数客户的好评",
              "工作认真，负责;工作认真负责，爱岗敬业，服从整体安排，形象良好； 对本职工作兢兢业业，锐意进取，乐于助人，关心同事，与同事相处融洽，善于 合作，起带头作用",
              "良好的个人形象和素养，专业技能或业务水平优秀，为公司利益不计个 人得失，对本职工作兢兢业业，锐意进取，为公司员工树立良好形象并起到带头 作用;为公司创造出较好的企业效益或社会效益",
              "此优秀员工工作认真刻苦，服务态度非常好，使经理在XXXXX的时候没有后顾之忧; 工作积极,热情周到，有一定的领导能力，专业技能业务水平优秀，业务水平也 在不断提高，关心每一位合鑫人，是我们大家学习的榜样;能胜任本职工作，爱 岗敬业、乐于助人，与同事相处融洽，服从整体安排，对本职工作兢兢业业，锐意进取，起榜样作用，为我们树立良好形象"};
    public static String salt="123456";
    public static String address[]={"安徽省和县姥桥","安徽省合肥安庆","吉林省长春吉大南区","吉林省北苑一公寓","吉林省南九公寓","吉林省大学城公寓","安徽马鞍山和县","安徽省马鞍山雨山区","安徽马鞍山天鹰"};

    public List<User>getUsers(int size){
        List<String> list= Arrays.asList(nametext.split(", "));
        logger.info(list.size()+"  "+list.toString());
        List<User>users=new ArrayList<>();
        Random random=new Random();
        for(int i=1000;i<1001+size;i++){
            int choose=random.nextInt(1000)+1;
            User user=new User();
            user.setCreate_date(new Date());
            user.setPassword(password);
            user.setSalt(salt);
            user.setUsername(list.get(i % 90));
            user.setAddress(address[choose%9]);
            user.setDescription(decription[choose%9]);
            user.setRole(role[choose%2]);
            user.setTel("1785412"+choose);
            user.setUrl("--------");
            users.add(user);
        }
        for(User user:users)
        {
            logger.info(user.toString());
        }
        return users;
    }
    public static void main(String args[])
    {
        long id= (long) 12.12;
        logger.info(""+id); //输出12
       /* List<String> list= Arrays.asList(nametext.split(", "));
        logger.info(list.size()+"--"+list.get(2)+"--");
        List<User>users=new UserInitData().getUsers(2);
        logger.info("--"+users.get(0).getUsername()+"--");
        *//**
         * == :是不相等
         * .equal() :是相等
         * *//*
        if(users.get(0).getUsername()==("王博"))
            logger.info("true");
        else logger.info("erroe");*/
    }
}
