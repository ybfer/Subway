package SubwayTest;

import Subway.Core;
import Subway.data.Line;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SubwayTest {

    @Test
    public void testGetLines(){
        List<Line> lines = Core.getLines("subway.txt");
        System.out.println(lines);
    }

    @Test
    public void testGetStations(){
        List<String[]> allStation = new ArrayList<>();
        allStation.add(new String[]{"刘园","西横堤","果酒厂","本溪路","勤俭道","洪湖里","西站",
                "西北角","西南角","二纬路","海光寺","鞍山道","营口道","小白楼",
                "下瓦房","南楼","土城","陈塘庄","复兴门","华山里","财经大学",
                "双林","李楼"});
        allStation.add(new String[]{"曹庄","卞兴","芥园西道","咸阳路","长虹公园","广开四马路",
                "西南角","鼓楼","东南角","建国道","天津站","远洋国际中心",
                "顺驰桥","靖江路","翠阜新村","屿东城","登州路","国山路","空港经济区","滨海国际机场"});
        allStation.add(new String[]{"南站","杨伍庄","学府工业区","高新区","大学城","华苑王顶堤",
                "红旗南路","周邓纪念馆","天塔","吴家窑","西康路","营口道","和平路","津湾广场",
                "天津站","金狮桥","中山路","北站","铁东路",
                "张兴庄","宜兴埠","天士力","华北集团","丰产河", "小淀"});
        allStation.add(new String[]{"北辰科技园北站","丹河北道站","北辰道站","职业大学站",
                "淮河道站","辽河北道站","宜兴埠北站","张兴庄站","志成路站","思源路站",
                "建昌道站","金钟河大街站","月牙河地铁站","幸福公园站",
                "靖江路站","成林道站","津塘路站","直沽站","下瓦房站","西南楼站",
                "文化中心站","天津宾馆站","肿瘤医院站","体育中心站","凌宾路站",
                "昌凌路站","中医一附院站","李七庄南站"});
        allStation.add(new String[]{"南孙庄","南何庄","大毕庄","金钟街","徐庄子","金钟河大街",
                "民权门","北宁公园","北站","新开河","外院附中","天泰路","北运河","北竹林",
                "西站","复兴路","人民医院","长虹公园","宜宾道","鞍山西道","天拖",
                "一中心医院","红旗南路","迎风道","南翠屏","水上公园东路","肿瘤医院",
                "天津宾馆","文化中心","乐园道","尖山路","黑牛城道","梅江道",
                "左江道","梅江公园","梅江会展中心","解放南路","洞庭路","梅林路"});
        allStation.add(new String[]{"天津站","大王庄","十一经路","直沽","东兴路",
                "中山门","一号桥","二号桥","新立","东丽开发区","小东庄","军粮城",
                "钢管公司","胡家园","塘沽站","泰达","市民广场","会展中心","东海路"});
        String[] lines = {"1号线", "2号线", "3号线", "5号线", "6号线", "9号线"};
        Core.getLines("subway.txt");

        int j = 0;
        for (String[] lineStation:
                allStation) {

            List<String> line = Core.getStations(lines[j]);

            int i = 0;
            for (String station:
                 lineStation) {
                Assert.assertEquals(station, line.get(i));
                i += 1;
            }
            j += 1;
        }


    }

    @Test
    public void testGetRoute(){
        String[] result = {"3" , "洪湖里" , "西站" , "6号线" ,"复兴路"};
        Core.getLines("subway.txt");
        List<String> routine = Core.getRoute("洪湖里", "复兴路");

        Assert.assertEquals(result.length, routine.size());

        int i = 0;
        for (String station:
                routine) {
            Assert.assertEquals(station, result[i]);
            i += 1;
        }

    }
}
