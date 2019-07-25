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
        allStation.add(new String[]{"��԰","�����","���Ƴ�","��Ϫ·","�ڼ��","�����","��վ",
                "������","���Ͻ�","��γ·","������","��ɽ��","Ӫ�ڵ�","С��¥",
                "���߷�","��¥","����","����ׯ","������","��ɽ��","�ƾ���ѧ",
                "˫��","��¥"});
        allStation.add(new String[]{"��ׯ","����","��԰����","����·","���繫԰","�㿪����·",
                "���Ͻ�","��¥","���Ͻ�","������","���վ","Զ���������",
                "˳����","����·","�丷�´�","�춫��","����·","��ɽ·","�ո۾�����","�������ʻ���"});
        allStation.add(new String[]{"��վ","����ׯ","ѧ����ҵ��","������","��ѧ��","��Է������",
                "������·","�ܵ˼����","����","���Ҥ","����·","Ӫ�ڵ�","��ƽ·","����㳡",
                "���վ","��ʨ��","��ɽ·","��վ","����·",
                "����ׯ","���˲�","��ʿ��","��������","�����", "С��"});
        allStation.add(new String[]{"�����Ƽ�԰��վ","���ӱ���վ","������վ","ְҵ��ѧվ",
                "���ӵ�վ","�ɺӱ���վ","���˲���վ","����ׯվ","־��·վ","˼Դ·վ",
                "������վ","���ӺӴ��վ","�����ӵ���վ","�Ҹ���԰վ",
                "����·վ","���ֵ�վ","����·վ","ֱ��վ","���߷�վ","����¥վ",
                "�Ļ�����վ","������վ","����ҽԺվ","��������վ","���·վ",
                "����·վ","��ҽһ��Ժվ","����ׯ��վ"});
        allStation.add(new String[]{"����ׯ","�Ϻ�ׯ","���ׯ","���ӽ�","��ׯ��","���ӺӴ��",
                "��Ȩ��","������԰","��վ","�¿���","��Ժ����","��̩·","���˺�","������",
                "��վ","����·","����ҽԺ","���繫԰","�˱���","��ɽ����","����",
                "һ����ҽԺ","������·","ӭ���","�ϴ���","ˮ�Ϲ�԰��·","����ҽԺ",
                "������","�Ļ�����","��԰��","��ɽ·","��ţ�ǵ�","÷����",
                "�󽭵�","÷����԰","÷����չ����","�����·","��ͥ·","÷��·"});
        allStation.add(new String[]{"���վ","����ׯ","ʮһ��·","ֱ��","����·",
                "��ɽ��","һ����","������","����","����������","С��ׯ","������",
                "�ֹܹ�˾","����԰","����վ","̩��","����㳡","��չ����","����·"});
        String[] lines = {"1����", "2����", "3����", "5����", "6����", "9����"};
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
        String[] result = {"3" , "�����" , "��վ" , "6����" ,"����·"};
        Core.getLines("subway.txt");
        List<String> routine = Core.getRoute("�����", "����·");

        Assert.assertEquals(result.length, routine.size());

        int i = 0;
        for (String station:
                routine) {
            Assert.assertEquals(station, result[i]);
            i += 1;
        }

    }
}
