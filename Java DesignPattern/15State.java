public class Work{
    private int hour;

    public void setHour(int hour){
        this.hour=hour;
    }

    public int getHour(){
        return hour;
    }

    private boolean finish=false;

    public void setFinish(boolean finish){
        this.finish=finish;
    }

    public boolean getFinish(){
        return finish;
    }

    public void WriteProgram(){
        if(hour<12){
            //
        }else if(hour<13){
            //
        }else if(hour<17){
            //
        }else{
            if(finish){
                //
            }else{
                if(hour<21){
                    //
                }else{
                    //
                }
            }
        }
    }
}

static void Main(String[] args){
    Work emergency=new Work();
    emergency.setHour(9);
    emergency.WriteProgram();
    
}