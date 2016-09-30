public class CashContext{
    CashSuper cs=null;

    public CashContext(String type){
        switch(type){
            case "normal":
                CashNormal cs0=new CashNormal();
                cs=cs0;
                break;
            case "cash_return":
                CashReturn cr1=new CashReturn();
                cs=cr1;
                break;
            case "cash_rebate":
                CashRebate cr2=new CashRebate();
                cs=cr2;
                break;
        }
    }

    public double GetResult(double money){
        return cs.acceptCash(money);
    }
}