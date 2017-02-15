package com.pch.common.tools;

import com.pch.common.util.StringUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author 潘朝辉
 * @version 1.0
 * @since 2017/2/9
 */
public class Tools {

    public static String[] srcArr = null;

    public static String projectPath = StringUtil.appendSeparatorEnd("C:") + StringUtil.appendSeparatorEnd
            ("idea_projects") + StringUtil.appendSeparatorEnd("trunk");
    public static String context = "one";
    public static String module = "hs";
    public static String entityImport = "model";
    public static String contextPath = StringUtil.appendSeparatorEnd("one");
    public static String javaPathOfMvn = StringUtil.appendSeparatorEnd("src") + StringUtil.appendSeparatorEnd("main")
            + StringUtil.appendSeparatorEnd("java");
    public static String basePackage = StringUtil.appendSeparatorEnd("com") + StringUtil.appendSeparatorEnd("cifm") +
            StringUtil.appendSeparatorEnd("one");

    public void genHsCode(String section) {
        genApiCode(section);
        genEntityCode(section);
        genImpCode(section);
    }

    public static void main(String[] args) {
        srcArr = new String[]{"BankChannelQueryAPI", "OpenFundAccoPreCheckAPI", "OpenFundAccountAPI",
                "OpenTradeAccountPreCheckAPI", "OpenTradeAccountAPI", "ChangeBankcardPreCheckAPI", "ChangeBankcardAPI",
                "CloseTradeAccountPreCheckAPI", "CloseTradeAccountAPI", "PaperInfoQueryAPI", "SubmitPaperInfoAPI",
                "ModifyTradePasswordAPI", "ResetTradePasswordAPI", "ModifyCustomerInfoAPI", "LoginCheckAPI",
                "MobileRegAPI", "CustInfoQueryAPI", "ResetRegUserPasswordAPI", "ModifyBankinfoAPI",
                "CustRiskInfoQueryAPI", "PwdEncrypAPI", "OpenTrustwayAPI", "OpenIdNoToUpperCaseAPI",
                "ModifyBankBranchNameAPI", "CGBBankcardUpdradeAPI", "ChangePwproAPI", "ValidatePwproAPI",
                "UpdateRegUserBindInfoAPI"};
        entityImport = "account";
//        new Tools().genHsCode("account");
        srcArr = new String[]{"MoneyRechargeAPI", "MoneyEncashAPI", "MoneyConsumeAPI", "OtherFundBuyMoneyAPI",
                "MoneyBuyOtherFundAPI", "MoneyMarketQueryAPI", "MoneyProfitQueryAPI", "MoneyTradeApplyQueryAPI",
                "MoneyShareQueryAPI", "MoneyFundFixDecRedeemAPI", "MoneyFundFixConvertAPI",
                "MoneyFundFixPreCheckAPI", "MoneyEIntelligentFixAdorEdAPI", "MoneyExponentFixAdorEdAPI"};
        entityImport = "trade,query";
//        new Tools().genHsCode("cashTreasure");
        srcArr = new String[]{"FundMarketQueryAPI", "PurchaseApplyPreCheckAPI", "PurchaseApplyAPI",
                "SubscribeApplyPreCheckAPI", "SubscribeApplyAPI", "RedeemPreCheckAPI", "RedeemAPI",
                "WithdrawApplyAPI", "ModifyBonusAPI", "RedeemListQueryAPI", "BonusListQueryAPI",
                "WithdrawListQueryAPI", "ConvertOutListAPI", "ConvertInListAPI", "FundConvertAPI",
                "FundConvertPreCheckAPI", "WithdrawApplyPreCheckAPI", "TransactionFeeCalQueryAPI"};
        entityImport = "trade";
//        new Tools().genHsCode("trade");
        srcArr = new String[]{"FixTradeAccoQueryAPI", "ChangeFixInvestStateAPI", "FixInvestQueryAPI",
                "FixDeclareAPI", "FirstvaludayQueryAPI"};
        entityImport = "trade";
//        new Tools().genHsCode("fixedInverstment");
        srcArr = new String[]{"BankAccountQueryAPI", "ShareQueryAPI", "TradeApplyQueryAPI",
                "FundAccountQueryAPI", "CustInfoQueryByMobileAPI", "TradeResultQueryAPI", "BrokerInfoQueryAPI",
                "BankStationQueryAPI", "TradeConfirmQueryAPI", "TradePasswordQueryAPI", "BonusQueryAPI",
                "ICustInfoWebQueryAPI", "FundMarketInfoQueryAPI", "HistoryFundMarketInfoQueryAPI", "QueryPwproAPI",
                "RateDiscountQueryAPI", "GetLastUsedTradeAccoAPI", "WorkDateQueryAPI"};
        entityImport = "query";
//        new Tools().genHsCode("query");
    }

    private void genImpCode(String section) {
        String CLASSNAME = StringUtil.upperFirst(module) + StringUtil.upperFirst(section) + "Imp";
        String PARENT_CLASSNAME = StringUtil.upperFirst(module) + StringUtil.upperFirst(section) + "Api";
        ArrayList<String> FUNCTION = new ArrayList<>();
        for (String s : srcArr) {
            String name = s.substring(0, s.indexOf("API")), resultName = name + "Result ";
            FUNCTION.add("\t" + "public " + resultName + StringUtil.lowerFirst(name) + "(" + name + "Param param) " +
                    "{\r\n" + "\t\t" + resultName + "result = new " + resultName + "();\r\n\t\tresult = ApiUtils" +
                    ".setResult" +
                    "(result, param, \"" + StringUtil.lowerFirst(name) + "API\");\r\n\t\treturn result;\r\n\t}");
        }
        List<String> importList = new ArrayList<>();
        importList.add("import com.cifm.one.hs.api." + PARENT_CLASSNAME + ";");
        importList.add("import com.cifm.one.hs.conf.ApiUtils;");
        for (String s : entityImport.split(",")) {
            importList.add("import com.hundsun.fund.fund.model." + s + ".*;");
        }
        importList.add("import org.springframework.stereotype.Service;");
        Java java = new Java("package " + basePackage.replaceAll("\\" + StringUtil.SEPARATOR, ".") + module + "." +
                "imp" + ";", importList, Arrays.asList("@Service"),
                CLASSNAME + " implements " + PARENT_CLASSNAME,
                Arrays.asList(),
                FUNCTION);
        String filePath = projectPath + StringUtil.appendSeparatorEnd(context) + StringUtil
                .appendSeparatorEnd(module + "-ser") + javaPathOfMvn +
                basePackage +
                StringUtil.appendSeparatorEnd
                        (module) + StringUtil.appendSeparatorEnd("imp");
        File file = new File(filePath + CLASSNAME + ".java");
        System.out.println(file);
        System.out.println(java);
        if (file.exists()) {
            File destFile = new File(filePath + CLASSNAME + "_bak" + ".java");
            if (!destFile.exists()) {
                file.renameTo(destFile);
            }
        }
        writeFile(file, java.toString());
    }

    private void genEntityCode(String section) {
        for (String s : srcArr) {
            String name = s.substring(0, s.indexOf("API"));
            String CLASSNAME = StringUtil.upperFirst(module) + name;
            String PARENT_CLASSNAME = name + "Result";
            List<String> importList = new ArrayList<>();
            for (String ei : entityImport.split(",")) {
                importList.add("import com.hundsun.fund.fund.model." + ei + ".*;");
            }
            importList.add("import org.springframework.stereotype.Service;");
            Java java = new Java("package " + basePackage.replaceAll("\\" + StringUtil.SEPARATOR, ".") + module + "." +
                    "entity" + "." + section + ";",
                    importList,
                    Arrays.asList(),
                    CLASSNAME + " extends " + PARENT_CLASSNAME,
                    Arrays.asList(),
                    Arrays.asList());
            String filePath = projectPath + StringUtil.appendSeparatorEnd(context) + StringUtil
                    .appendSeparatorEnd(module + "-api") + javaPathOfMvn +
                    basePackage +
                    StringUtil.appendSeparatorEnd
                            (module) + StringUtil.appendSeparatorEnd("entity") + StringUtil.appendSeparatorEnd(section);
            File file = new File(filePath + CLASSNAME + ".java");
            if (file.exists()) {
                File destFile = new File(filePath + CLASSNAME + "_bak" + ".java");
                if (!destFile.exists()) {
                    file.renameTo(destFile);
                }
            } else {
                file.getParentFile().mkdirs();
            }
            writeFile(file, java.toString());
        }
    }

    public void genApiCode(String section) {
        String CLASSNAME = StringUtil.upperFirst(module) + StringUtil.upperFirst(section) + StringUtil.upperFirst
                ("api");
        ArrayList<String> FUNCTION = new ArrayList<>();
        for (String s : srcArr) {
            String name = s.substring(0, s.indexOf("API"));
            FUNCTION.add("\t" + name + "Result" + " " + StringUtil.lowerFirst(name) + "(" + name + "Param" + " param)" +
                    ";");
        }
        List<String> importList = new ArrayList<>();
        importList.add("import org.springframework.stereotype.Service;");
        for (String s : entityImport.split(",")) {
            importList.add("import com.hundsun.fund.fund.model." + s + ".*;");
        }
        Java java = new Java("package " + basePackage.replaceAll("\\" + StringUtil.SEPARATOR, ".") + module + "." +
                "api" + ";",
                importList,
                Arrays.asList("@Service"),
                CLASSNAME,
                Arrays.asList(),
                FUNCTION);
        java.setInterface(true);
        String filePath = projectPath + StringUtil.appendSeparatorEnd(context) + StringUtil
                .appendSeparatorEnd(module + "-api") + javaPathOfMvn +
                basePackage +
                StringUtil.appendSeparatorEnd
                        (module) + StringUtil.appendSeparatorEnd("api");
        File file = new File(filePath + CLASSNAME + ".java");
        if (file.exists()) {
            File destFile = new File(filePath + CLASSNAME + "_bak" + ".java");
            if (!destFile.exists()) {
                file.renameTo(destFile);
            }
        }
        writeFile(file, java.toString());
    }

    public void writeFile(File file, String content) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            byte[] bytes = content.getBytes();
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fos) {
                try {
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Java {

        private String PACKAGE;
        private List<String> IMPORT;
        private List<String> ANNOTATION;
        private String CMT = String.format("/**\n" +
                " * @author 潘朝辉\n" +
                " * @version 1.0\n" +
                " * @since %s\n" +
                " */", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
        private String CLASSNAME;
        private List<String> FIELD;
        private List<String> FUNCTION;

        private boolean isInterface;

        public Java() {
        }

        public Java(String PACKAGE, List<String> IMPORT, List<String> ANNOTATION, String CLASSNAME, List<String> FIELD,
                    List<String> FUNCTION) {
            this.PACKAGE = PACKAGE;
            this.IMPORT = IMPORT;
            this.ANNOTATION = ANNOTATION;
            this.CLASSNAME = CLASSNAME;
            this.FIELD = FIELD;
            this.FUNCTION = FUNCTION;
        }

        public String getPACKAGE() {
            return PACKAGE;
        }

        public void setPACKAGE(String PACKAGE) {
            this.PACKAGE = PACKAGE;
        }

        public List<String> getIMPORT() {
            return IMPORT;
        }

        public void setIMPORT(List<String> IMPORT) {
            this.IMPORT = IMPORT;
        }

        public List<String> getANNOTATION() {
            return ANNOTATION;
        }

        public void setANNOTATION(List<String> ANNOTATION) {
            this.ANNOTATION = ANNOTATION;
        }

        public String getCMT() {
            return CMT;
        }

        public void setCMT(String CMT) {
            this.CMT = CMT;
        }

        public String getCLASSNAME() {
            return CLASSNAME;
        }

        public void setCLASSNAME(String CLASSNAME) {
            this.CLASSNAME = CLASSNAME;
        }

        public List<String> getFIELD() {
            return FIELD;
        }

        public void setFIELD(List<String> FIELD) {
            this.FIELD = FIELD;
        }

        public List<String> getFUNCTION() {
            return FUNCTION;
        }

        public void setFUNCTION(List<String> FUNCTION) {
            this.FUNCTION = FUNCTION;
        }

        public boolean isInterface() {
            return isInterface;
        }

        public void setInterface(boolean anInterface) {
            isInterface = anInterface;
        }

        @Override
        public String toString() {

            StringBuilder sb0 = new StringBuilder();
            for (String s : IMPORT) {
                sb0.append(StringUtil.appendEnterEnd(s));
            }
            StringBuilder sb05 = new StringBuilder();
            for (String s : ANNOTATION) {
                sb05.append(StringUtil.appendEnterEnd(s));
            }
            StringBuilder sb = new StringBuilder();
            for (String s : FIELD) {
                sb.append(StringUtil.append2EnterEnd(s));
            }
            StringBuilder sb1 = new StringBuilder();
            for (String s : FUNCTION) {
                sb1.append(StringUtil.append2EnterEnd(s));
            }
            return StringUtil.append2EnterEnd(PACKAGE) + StringUtil.appendEnterEnd(sb0.toString()) + StringUtil
                    .appendEnterEnd(CMT) +
                    sb05.toString() + StringUtil.append2EnterEnd("public " + (isInterface ? "interface" : "class") +
                    " " +
                    CLASSNAME
                    + " {")
                    + sb.toString()
                    + sb1.toString() + "}";
        }
    }
}

