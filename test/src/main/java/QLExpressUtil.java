import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 */
//@Slf4j
public class QLExpressUtil {
    private final static Log log = LogFactory.getLog(QLExpressUtil.class);

    /**
     * ExpressRunner 中间件
     */
    private static ExpressRunner runner = new ExpressRunner();

    /**
     * 规则计算条件是否满足, 返回true/false
     */
    public static boolean conditionExpress(String express, DefaultContext<String, Object> context) {
//        log.info("express={},context={}", express, context);
        if (Objects.isNull(express)) {
            log.info("conditionVo or computeResult is null");
            return Boolean.FALSE;
        }
        try {
            Boolean result = (Boolean) runner.execute(express, context, null, true, false);
//            log.info("expression={},computeResult={},result={}", express, context, result);
            return result;
        } catch (Exception e) {
            log.error("conditionExpress error!", e);
        }
        return Boolean.FALSE;
    }

    /**
     * 公式计算
     */
    public static BigDecimal express(String express, DefaultContext<String, Object> context) throws Exception {
        return express(express, context, 0);
    }

    public static BigDecimal express(String express, DefaultContext<String, Object> expressContext, int scale) throws Exception {
//        log.info("express={},expressContext={}", express, expressContext);
        try {
            if (Objects.isNull(expressContext) || Objects.isNull(express)) {
                throw new Exception("express or expressContext is null");
            }
            Object object = runner.execute(express, expressContext, null, true, false);
            BigDecimal result = new BigDecimal((Double) object).setScale(scale, BigDecimal.ROUND_HALF_UP);
//            log.info("expressContext={},express={},result={}", expressContext, express, result);
            return result;
        } catch (Exception e) {
            log.error("express error!", e);
            e.printStackTrace();
            throw e;
        }
    }

    /**
     *
     */
    public static void main(String[] args) throws Exception {
        System.out.println("123");
        DefaultContext context = new DefaultContext();
        context.put("x", 9);
        boolean b = conditionExpress("x > 0 && x <= 10", context);
        System.out.println(b);
        BigDecimal express = express("x-0.3", context, 1);
        System.out.println(express);

        int aaa = 12;
        String s = "\n" +
                "[\n" +
                "{\"condition\":\"x > 0 && x <= 10\",\"minExpress\":\"x-0.3\",\"maxExpress\":\"x+0.3\"},\n" +
                "{\"condition\":\"x > 10\",\"minExpress\":\"x-x*0.03\",\"maxExpress\":\"x+x*0.03\"}\n" +
                "]";
        JSONArray jsonArray = JSONArray.parseArray(s);
        for (Object o : jsonArray) {
            DefaultContext context1 = new DefaultContext();
            context1.put("x", aaa);
            JSONObject a = (JSONObject) o;
            if (conditionExpress(a.getString("condition"), context1)) {
                System.out.print(express(a.getString("minExpress"), context1, 2) + "%");
                System.out.print("-");
                System.out.println(express(a.getString("maxExpress"), context1, 2) + "%");
                break;
            }
        }

        System.out.println("****");
        DefaultContext context2 = new DefaultContext();
        context2.put("x", aaa);
        String minS = "if(x > 0 && x <= 10) then return x-0.3 else return x-x*0.03";
        System.out.println(runner.execute(minS, context2, null, true, false));

        //BigDecimal result = new BigDecimal((Double) 18.66).setScale(0, BigDecimal.ROUND_HALF_UP);
//        DefaultContext<String, Object> expressContext = new DefaultContext<>();
//        expressContext.put("UV", 1000000);
//        expressContext.put("baseRatio", 0.03);
//        expressContext.put("callUV", 2000000);
//        expressContext.put("callRatio", 0.5);
//        String express = "UV * baseRatio + callUV * callRatio";
//        ExpressRunner runner = new ExpressRunner();
//        Object result = runner.execute(express, expressContext, null, true, false);
//        System.out.println("政策规则表达式计算：" + express + " = " + new BigDecimal((Double) result));

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y/M/d");
//        simpleDateFormat.setLenient(false);
//        Date start = simpleDateFormat.parse("20211/12/01");
//        System.out.println(start);

//        DateTimeFormatter

//        simpleDateFormat.setLenient(false);
//        Date start = simpleDateFormat.parse("20211/12/01");
//        System.out.println(start);

//        System.out.println("2021/1/30；2022/1/1-2022/2/6");
//        String dbcTimeStr = AsciiUtil.sbc2dbcString("2021/1/30；2022/1/1-2022/2/6");
//        // 特殊字符替换
//        String timePeriods = dbcTimeStr.replace("\n", "")
//                .replace("到", "-")
//                .replace("至", "-")
//                .replace("~", "-")
//                .replace("——", "-")
//                .replace("年", "/")
//                .replace("月", "/")
//                .replace("日", "")
//                .replace("[", "")
//                .replace("]", "")
//                .replace(" ", "")
//                .replaceAll("-+", "-")
//                .trim();
//        String[] periods = timePeriods.split(",");
//        for (String period : periods) {
//            System.out.println(period);
//        }
//
//        for (String period : periods) {
//            String[] dates = period.split("-");
//            for (String date : dates) {
//                System.out.println("日期"+date);
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
//                simpleDateFormat.setLenient(false);
//                System.out.println("格式化日期"+simpleDateFormat.parse(date));
//            }
//        }

    }
}
