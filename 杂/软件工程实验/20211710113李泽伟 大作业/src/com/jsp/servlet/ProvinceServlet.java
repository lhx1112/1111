package chap09.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import com.google.gson.Gson;

@WebServlet(name = "ProvinceServlet",urlPatterns = "/ProvinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> location=new HashMap<>();
        location.put("省份",new String[]{"浙江","河北","山西","辽宁","吉林","黑龙江","江苏","安徽","福建","江西","山东","河南","湖北","湖南","广东","海南","四川","贵州","云南","陕西","甘肃","青海","台湾","内蒙古","广西","西藏","宁夏","新疆","北京市","天津市","上海市","重庆","香港","澳门"});
        location.put("北京", new String[]{"东城区", "西城区", "崇文区", "宣武区", "朝阳区", "海淀区", "丰台区", "石景山区", "房山区", "通州区", "顺义区", "昌平区", "大兴区", "怀柔区", "平谷区", "门头沟区", "密云县", "延庆县"});
        location.put("天津",new String[]{"和平区","河东区","河西区","南开区","河北区","红桥区","东丽区","西青区","北辰区","津南区","武清区","宝坻区","滨海新区","静海县","宁河县","蓟县"});
        location.put("上海",new String[]{"黄浦区","卢湾区","徐汇区","长宁区","静安区","普陀区","闸北区","虹口区","杨浦区","闵行区","宝山区","嘉定区","浦东新区","金山区","松江区","青浦区","奉贤区","崇明县"});
        location.put("重庆",new String[]{"渝中区","大渡口区","江北区","南岸区","北碚区","渝北区","巴南区","长寿区","双桥区","沙坪坝区","万盛区","万州区","涪陵区","黔江区","永川区","合川区","江津区","九龙坡区","南川区","綦江县","潼南县","荣昌县","璧山县","大足县","铜梁县","梁平县","开县","忠县","城口县","垫江县","武隆县","丰都县","奉节县","云阳县","巫溪县","巫山县","石柱土家族自治县","秀山土家族苗族自治县","酉阳土家族苗族自治县","彭水苗族土家族自治县"});
        location.put("河北",new String[]{"石家庄","唐山","秦皇岛","邯郸","邢台","保定","张家口","承德","沧州","廊坊","衡水"});
        location.put("山西",new String[]{"太原","大同","阳泉","长治","晋城","朔州","晋中","运城","忻州","临汾","吕梁"});
        location.put("辽宁",new String[]{"沈阳","大连","鞍山","抚顺","本溪","丹东","锦州","营口","阜新","辽阳","盘锦","铁岭","朝阳","葫芦岛"});
        location.put("吉林",new String[]{"长春","吉林","四平","辽源","通化","白山","松原","白城","延边朝鲜族自治州"});
        location.put("黑龙江",new String[]{"哈尔滨","齐齐哈尔","鹤岗","双鸭山","鸡西","大庆","伊春","牡丹江","佳木斯","七台河","黑河","绥化","大兴安岭"});
        location.put("江苏",new String[]{"南京","苏州","无锡","常州","镇江","南通","泰州","扬州","盐城","连云港","徐州","淮安","宿迁"});
        location.put("浙江",new String[]{"杭州","宁波","温州","嘉兴","湖州","绍兴","金华","衢州","舟山","台州","丽水"});
        location.put("安徽",new String[]{"合肥","芜湖","蚌埠","淮南","马鞍山","淮北","铜陵","安庆","黄山","滁州","阜阳","宿州","巢湖","六安","亳州","池州","宣城"});
        location.put("福建",new String[]{"福州","厦门","莆田","三明","泉州","漳州","南平","龙岩","宁德"});
        location.put("江西",new String[]{"南昌","景德镇","萍乡","九江","新余","鹰潭","赣州","吉安","宜春","抚州","上饶"});
        location.put("山东",new String[]{"济南","青岛","淄博","枣庄","东营","烟台","潍坊","济宁","泰安","威海","日照","莱芜","临沂","德州","聊城","滨州","菏泽"});
        location.put("河南",new String[]{"郑州","开封","洛阳","平顶山","安阳","鹤壁","新乡","焦作","濮阳","许昌","漯河","三门峡","南阳","商丘","信阳","周口","驻马店"});
        location.put("湖北",new String[]{"武汉","黄石","十堰","荆州","宜昌","襄樊","鄂州","荆门","孝感","黄冈","咸宁","随州","恩施"});
        location.put("湖南",new String[]{"长沙","株洲","湘潭","衡阳","邵阳","岳阳","常德","张家界","益阳","郴州","永州","怀化","娄底","湘西"});
        location.put("广东",new String[]{"广州","深圳","珠海","汕头","韶关","佛山","江门","湛江","茂名","肇庆","惠州","梅州","汕尾","河源","阳江","清远","东莞","中山","潮州","揭阳","云浮"});
        location.put("海南",new String[]{"海口","三亚"});
        location.put("四川",new String[]{"成都","自贡","攀枝花","泸州","德阳","绵阳","广元","遂宁","内江","乐山","南充","眉山","宜宾","广安","达州","雅安","巴中","资阳","阿坝","甘孜","凉山"});
        location.put("贵州",new String[]{"贵阳","六盘水","遵义","安顺","铜仁","毕节","黔西南","黔东南","黔南"});
        location.put("云南",new String[]{"昆明","曲靖","玉溪","保山","昭通","丽江","普洱","临沧","德宏","怒江","迪庆","大理","楚雄","红河","文山","西双版纳"});
        location.put("陕西",new String[]{"西安","铜川","宝鸡","咸阳","渭南","延安","汉中","榆林","安康","商洛"});
        location.put("甘肃",new String[]{"兰州","嘉峪关","金昌","白银","天水","武威","酒泉","张掖","庆阳","平凉","定西","陇南","临夏","甘南"});
        location.put("青海",new String[]{"西宁","海东","海北","海南","黄南","果洛","玉树","海西"});
        location.put("内蒙古",new String[]{"呼和浩特","包头","乌海","赤峰","通辽","鄂尔多斯","呼伦贝尔","巴彦淖尔","乌兰察布","锡林郭勒盟","兴安盟","阿拉善盟"});
        location.put("广西",new String[]{"南宁","柳州","桂林","梧州","北海","防城港","钦州","贵港","玉林","百色","贺州","河池","来宾","崇左"});
        location.put("西藏",new String[]{"拉萨","那曲","昌都","林芝","山南","日喀则","阿里"});
        location.put("宁夏",new String[]{"银川","石嘴山","吴忠","固原","中卫"});
        location.put("新疆",new String[]{"乌鲁木齐","克拉玛依","吐鲁番","哈密","和田","阿克苏","喀什","克孜勒苏","巴音郭楞","昌吉","博尔塔拉","伊犁","塔城","阿勒泰"});
        location.put("香港",new String[]{"香港岛","九龙东","九龙西","新界东","新界西"});
        location.put("澳门",new String[]{"澳门半岛","离岛"});
        location.put("台湾",new String[]{"台北","高雄","基隆","新竹","台中","嘉义","台南市"});
        location.put("--请选择省份--",new String[]{});
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String province=(String)request.getParameter("province");
        System.out.println(province);
        response.getWriter().write(new Gson().toJson(location.get(province)));
    }
}