package com.ldd.flower.common;

import com.ldd.flower.entity.Flower;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author liudongdong
 * @Date Created in 8:57 2019/9/7
 * @Description
 */
public class FlowerInitData {
    /*7种花*/
    private static String name[]={"紫菜","融齿捕蝇草","珊瑚花凤梨","柠檬留兰香","王妃雷神","小花鸢尾","七姊妹"};
    private static String color[]={"红色","黄色","紫色","白色","橙色","蓝色"};
    private static String iconurl[]={"紫菜.png","融齿捕蝇草.png","珊瑚花凤梨.png","柠檬留兰香.png","王妃雷神.png","小花鸢尾.png","七姊妹.png"};
    private static String type[]={"藻类植物","食虫植物","凤梨科植物","多年生草本花卉","多肉多浆植物","多年生草本花卉","灌木花卉"};
    private static String flowerperiod[]={"40天","俩月","10月","三月","一月"};
    private static String waterperiod[]={"一周","俩周","10天","三天"};
    private static String cuttingperiod[]={"一周","俩周","10天","三天","一月"};
    private static String lightinfo[]={"1000px左右","较阴暗","适合强光"};
    private static String description[]={"紫菜（Porphyra），是在海中互生藻类的统称。红藻纲，红毛菜科。藻体呈膜状，称为叶状体。紫色或褐绿色。形状随种类而异。紫菜属海产红藻。叶状体由包埋于薄层胶质中的一层细胞组成，深褐、红色或紫色。紫菜固着器盘状，假根丝状。生长于浅海潮间带的岩石上。种类多，主要有条斑紫菜、坛紫菜、甘紫菜等。中国沿海地区已进行人工栽培。21世纪初中国紫菜产量跃居世界第一位。富含蛋白质和碘、磷、钙等。供食用和药用。",
            "融齿捕蝇草是在组培过程中发生变异而诞生的一种早期非常难得的怪异捕蝇草园艺品种，由一位德国食虫植物爱好者培育和挑选出来。成为古怪系捕蝇草中非常具有竞争力的品种，并且逐渐得到普及。 捕蝇草属于茅膏菜科捕蝇草属(Dionaea)，全属仅1种，但有较多的园艺种、变种，原产美国卡罗莱纳州的大西洋沿岸平原地区，威尔明顿市周边100公里范围内。生长在稀树草原沼泽的泥炭或沙质土壤中，生长环境常年潮湿",
            "莺歌凤梨别名岐花鹦哥凤梨、珊瑚花凤梨，株高20厘米左右。叶从生，呈杯形，叶带状，长20-30 厘米，宽l.5-2厘米，肉质，较薄，鲜绿色，有光泽，复穗状花序，花刁细小，直立，自叶丛中抽生。 花苞刁状，基部艳红，端部黄绿色或嫩黄色，花小，黄色。原产巴西，中国国近几年有引种，各地均有栽培，为我国栽培最广泛、也最流行的盆栽观叶植物并不是梨。",
            "多年生草本，有具叶的匍枝，全体无毛或近于无毛。茎外倾，曲折，高30—60厘米，多分枝，四棱形，微具槽。",
            "王妃雷神为龙舌兰科龙舌兰属植物，属园艺种；原产墨西哥中南部，植株矮小，无茎；叶质厚而软，叶宽而短，是雷神的小型变种。其常见的变种还有王妃雷神白中斑、王妃雷神浅中斑、王妃雷神黄中斑、王妃雷神白覆轮、王妃雷神黄覆轮等，其观赏价值都很高，为园艺珍品。",
            "小花鸢尾（学名：Iris speculatrix Hance）：多年生草本，植株基部围有棕褐色的老叶叶鞘纤维及披针形的鞘状叶。根状茎二歧状分枝，斜伸，棕褐色；根较粗壮，少分枝。叶略弯曲，暗绿色，有光泽，剑形或条形，有3-5条纵脉。花茎光滑，不分枝或偶有侧枝，有1-2枚茎生叶；苞片2-3枚，草质，绿色，狭披针形，内包含有1-2朵花；外花被裂片匙形，有深紫色的环形斑纹，内花被裂片狭倒披针形，直立。",
            "七姊妹也称十姐妹，是蔷薇科蔷薇属多花蔷薇的一个变种。花重瓣，深粉红色，常7-10朵簇生在一起，具芳香。蔷薇是落叶或半常绿灌木，茎直立或攀缘，通常有皮刺。叶互生，奇数羽状复叶，具托叶，小叶有锯齿。花单生或组成伞房花序,生于新梢顶端，花径一般约2厘米。栽培供观赏，可作护坡及棚架之用。"
    };
    public List<Flower>getFlower()
    {
        List<Flower>flowers=new ArrayList<>(7);
        Random random=new Random();
        for(int i=0;i<7;i++){
            int choose=random.nextInt(100);
            Flower flower=new Flower();
            flower.setName(name[i]);
            flower.setColor(color[choose%6]);
            flower.setIconurl(iconurl[i]);
            flower.setType(type[i]);
            flower.setDescription(description[i]);
            flower.setCuttingperiod(cuttingperiod[choose%5]);
            flower.setGrowperiod(flowerperiod[choose%5]);
            flower.setWaterperiod(waterperiod[choose%4]);
            flower.setCreatedate(new Date());
            flowers.add(flower);
        }
        return flowers;
    }
}
