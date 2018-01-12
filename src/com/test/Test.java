package com.test;


import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Foo {
	private  int i = 3;
	public Foo(){
		
	}
	public Foo(int i){
		//this.i=i;
	}
	public String toString(){
		return i+"";
	}
	}
public class Test {
	public Test(){
		//System.out.println("Test() constractor calling....");
	}
	private static Test test=new Test();
	public static void main(String args[]) {
		/*
		Map<String, Foo> obj=new HashMap<String, Foo>();
		obj.put("a", new Foo());
		obj.put(null, null);
		obj.put(null, new Foo());
		System.out.println(obj);
		Map<String, Foo> objht=new Hashtable<String, Foo>();
		//objht.put(null, new Foo());
		objht.put("nn", null);
		System.out.println(objht);
		
		
"REC_ID,UNQ_ID,CLM_SFX,GRP_ID,BNK_COD,COV_MIN,COV_CLAS,PMT_CAT,STATUS,PMT_TYP,RECO_TYP,PMT_ACT,PREV_TYP,CHK_NUM,ISS_DTE,PAID,FRM_DTE,TO_DTE,PYE_TYP,PYE_ID,PYE_SFX,PYE_NAM,MAIL_TO,PYE_ADR_1,PYE_ADR_2,PYE_CITY,PYE_STATE,PYE_ZIP,REQ_AMT,RED_COD,COM_TXT,FIN_PMT,COMP_DAY,REP_DTE,SCH_DTE,PRC_FLG,MED_FEE,CLR_STAT,CLR_BY,CLR_DTE,IND_FLG,HLD_COD,HLD_USR,SCH_FLG,CLS_CLM,CLS_CLMT,COMP_AMT,COLA_AMT,DEP_AMT,BILL_ACC,BILL_DTE,PMT_CALC,VER_NUM,BULK_PMT,SITE_COD,BKP_WHLD,CMP_NAM,ADD_DTE,ADD_BY,CHG_DTE,CHG_BY,DB_OWNER,AUTH_DTE,AUTH_BY,CONVERSION_RATE,CURRENCY_TYPE,ENTERED_AMOUNT,WINS_TRANS,WINS_TRNTYP,WINS_PAYTYP,ACCT_DTE,EXP_AMT,PYR_CHK_NUM,CDS_CHK_NUM,PYE_COUNTRY,ACQ_PMT,PYE_FST_NAM,PYE_LST_NAM,PYE_ADR_3,PAYMENT_METHOD,BILL_INV,BATCH_RUN_SEQ_NUM,REASON_COD,CHK_SPECIAL_HNDL_IND,CHK_SPECIAL_HNDL_METHOD_CD,CHK_SPECIAL_HNDL_REASON,DED_REIMBURSE_IND,RENTAL_DAYS_PD,FEED_COD,ISSUED_BY_CD,FEE_COD,PD_AGAINST_RSV_IND,RSV_AMT,APP_VEN_IND,WAIVED_DED_AMT,CLMT_REP_PAYEE_IND,PMT_CLASSIFICATION_COD,ORIG_REC_ID,REQUEST_DISPOSITION_DATE,REQUEST_STATUS_CODE,BILL_FREQ,DETAIL_LINE_REF,REPORT_STAT_IND,RENTAL_DAILY_AMT,RENTAL_START_DTE,SALES_TAX,HOLDBACK_IND,RENTAL_END_DTE,SAL_SUB,CHK_TYPE_COD,DIM_DEDUCT_AMOUNT,DIM_POLICY_DEDUCT,NEGLIGENCE_PCT,ORIG_DEDUCT_AMOUNT,ORIG_POLICY_DEDUCT,DENIAL_REASON_TXT,REMARKS,SPEC_CHECK_HNDL_LOC,STATEMENT_FORMAT_COD,CONTROL_NUMBER" 
"'0005650785','X6364434','001','C6364434','01','MED','M','RECMED','C','R','OT','Y','',null,'2016-10-26 00:00:00.0',null,'2016-04-06 00:00:00.0',null,null,null,null,'JEFFREY D. CHRISTOPHER','JEFFREY D. CHRISTOPHER',null,'1686 WAVERLY WAY','BALTIMORE','MD',null,null,null,null,'N',null,null,null,'0','',null,null,null,'N','','','','','',null,null,null,null,null,null,'','N',null,'N','',null,null,null,null,'CEIC Conversion','2016-04-06 16:04:29.0','LEARYJ','0.0000','USA',null,'','','','2016-04-06 00:00:00.0',null,null,null,'US','N','JEFFREY D. CHRISTOPH','JEFFREY D. CHRISTOPHER',null,4,'',null,'','','','',null,null,'','','','',null,'','0.0000',null,'','',null,'','','0','',null,null,null,'',null,'','','0.0000',null,'0.0','0.0000',null,null,null,'','',null"

		*/
		String column="REC_ID,UNQ_ID,CLM_SFX,GRP_ID,BNK_COD,COV_MIN,COV_CLAS,PMT_CAT,STATUS,PMT_TYP,RECO_TYP,PMT_ACT,PREV_TYP,CHK_NUM,ISS_DTE,PAID,FRM_DTE,TO_DTE,PYE_TYP,PYE_ID,PYE_SFX,PYE_NAM,MAIL_TO,PYE_ADR_1,PYE_ADR_2,PYE_CITY,PYE_STATE,PYE_ZIP,REQ_AMT,RED_COD,COM_TXT,FIN_PMT,COMP_DAY,REP_DTE,SCH_DTE,PRC_FLG,MED_FEE,CLR_STAT,CLR_BY,CLR_DTE,IND_FLG,HLD_COD,HLD_USR,SCH_FLG,CLS_CLM,CLS_CLMT,COMP_AMT,COLA_AMT,DEP_AMT,BILL_ACC,BILL_DTE,PMT_CALC,VER_NUM,BULK_PMT,SITE_COD,BKP_WHLD,CMP_NAM,ADD_DTE,ADD_BY,CHG_DTE,CHG_BY,DB_OWNER,AUTH_DTE,AUTH_BY,CONVERSION_RATE,CURRENCY_TYPE,ENTERED_AMOUNT,WINS_TRANS,WINS_TRNTYP,WINS_PAYTYP,ACCT_DTE,EXP_AMT,PYR_CHK_NUM,CDS_CHK_NUM,PYE_COUNTRY,ACQ_PMT,PYE_FST_NAM,PYE_LST_NAM,PYE_ADR_3,PAYMENT_METHOD,BILL_INV,BATCH_RUN_SEQ_NUM,REASON_COD,CHK_SPECIAL_HNDL_IND,CHK_SPECIAL_HNDL_METHOD_CD,CHK_SPECIAL_HNDL_REASON,DED_REIMBURSE_IND,RENTAL_DAYS_PD,FEED_COD,ISSUED_BY_CD,FEE_COD,PD_AGAINST_RSV_IND,RSV_AMT,APP_VEN_IND,WAIVED_DED_AMT,CLMT_REP_PAYEE_IND,PMT_CLASSIFICATION_COD,ORIG_REC_ID,REQUEST_DISPOSITION_DATE,REQUEST_STATUS_CODE,BILL_FREQ,DETAIL_LINE_REF,REPORT_STAT_IND,RENTAL_DAILY_AMT,RENTAL_START_DTE,SALES_TAX,HOLDBACK_IND,RENTAL_END_DTE,SAL_SUB,CHK_TYPE_COD,DIM_DEDUCT_AMOUNT,DIM_POLICY_DEDUCT,NEGLIGENCE_PCT,ORIG_DEDUCT_AMOUNT,ORIG_POLICY_DEDUCT,DENIAL_REASON_TXT,REMARKS,SPEC_CHECK_HNDL_LOC,STATEMENT_FORMAT_COD,CONTROL_NUMBER"; 
		String value="'0005650785','X6364434','001','C6364434','01','MED','M','RECMED','C','R','OT','Y','',null,'2016-10-26 00:00:00.0',null,'2016-04-06 00:00:00.0',null,null,null,null,'JEFFREY D. CHRISTOPHER','JEFFREY D. CHRISTOPHER',null,'1686 WAVERLY WAY','BALTIMORE','MD',null,null,null,null,'N',null,null,null,'0','',null,null,null,'N','','','','','',null,null,null,null,null,null,'','N',null,'N','',null,null,null,null,'CEIC Conversion','2016-04-06 16:04:29.0','LEARYJ','0.0000','USA',null,'','','','2016-04-06 00:00:00.0',null,null,null,'US','N','JEFFREY D. CHRISTOPH','JEFFREY D. CHRISTOPHER',null,4,'',null,'','','','',null,null,'','','','',null,'','0.0000',null,'','',null,'','','0','',null,null,null,'',null,'','','0.0000',null,'0.0','0.0000',null,null,null,'','',null";
		String[] columnArr= column.split(",");
		String[] valueArr= value.split(",");
		System.out.println(columnArr.length +";"+valueArr.length);
		Map<String,String> hm=new HashMap<String,String>();
		
		for(int i=0;i<columnArr.length;i++){
			hm.put(columnArr[i], valueArr[i]);
		}
		TreeMap<String, String> ht=new TreeMap<String,String>(hm);
		System.out.println(ht.toString());
	}
	
	
}
class A {public A(){}
	B b;
}
class B {public B(){}
	A a;
}
class C {public C(){}}