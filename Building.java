package Totality;
//Класс зданий деревни
public class Building {
    protected String name; //Тип строения
    private int quantityAdd; //Количество возрастающих параметров
    private String[] addParam = new String[2]; //Массив возрастающих параметров
    private int[] quanAddParam = new int[2]; //Массив прибавок параметров
    private int quantityDec; //Количество убывающих параметров
    private String[] decParam = new String[2]; //Массив возрастающих параметров
    private int[] quanDecParam = new int[2]; //Массив прибавок параметров
    private int profit; //Приносит денежную прибыль
    private int wane; //Приносит денежную убыль
    protected int CostOfRestoration; //Стоимость восстановления
    protected int CostLevel; //Стоимость уровня
    protected int level; //Уровень строения
    protected boolean working; //Работоспособность строения
    private int LossOfPopulation; //Убыль населения, если здание не работает, в %
    private String addParameter; //Название дополнительного параметра, который будет убывать при нерабочим здании
    private int reduce; //Кол-во убытка параметра
    private String s1;
    private Village vil;
    private static final double CoefficientPar1 = 0.1;
    private static final double CoefficientPar2 = 0.01;
    private static final double CoefficientPar3 = 0.35;
    //Конструктор
    public Building(String str, Village utopaevo) {
        name = str.substring(0, str.indexOf("/"));
        str = str.substring(str.indexOf("/") + 1, str.length());
        quantityAdd = Integer.parseInt(str.substring(0, str.indexOf("/")));
        str = str.substring(str.indexOf("/") + 1, str.length());
        if(quantityAdd != 0){
            s1 = str.substring(0, str.indexOf("/")) + " ";
            str = str.substring(str.indexOf("/") + 1, str.length());
            for(int i = 0; i < quantityAdd; i++) {
                addParam[i] = s1.substring(0, s1.indexOf(" "));
                s1 = s1.substring(s1.indexOf(" ") + 1, s1.length());
                quanAddParam[i] = Integer.parseInt(s1.substring(0, s1.indexOf(" ")));
                s1 = s1.substring(s1.indexOf(" ") + 1, s1.length());
            }
        }
        quantityDec = Integer.parseInt(str.substring(0, str.indexOf("/")));
        str = str.substring(str.indexOf("/") + 1, str.length());
        if(quantityDec != 0) {
            s1 = str.substring(0, str.indexOf("/")) + " ";
            str = str.substring(str.indexOf("/") + 1, str.length());
            for(int i = 0; i < quantityDec; i++) {
                decParam[i] = s1.substring(0, s1.indexOf(" "));
                s1 = s1.substring(s1.indexOf(" ") + 1, s1.length());
                quanDecParam[i] = Integer.parseInt(s1.substring(0, s1.indexOf(" ")));
                s1 = s1.substring(s1.indexOf(" ") + 1, s1.length());
            }
        }
        profit = Integer.parseInt(str.substring(0, str.indexOf("/")));
        str = str.substring(str.indexOf("/") + 1, str.length());
        wane = Integer.parseInt(str.substring(0, str.indexOf("/")));
        str = str.substring(str.indexOf("/") + 1, str.length());
        CostOfRestoration = Integer.parseInt(str.substring(0, str.indexOf("/")));
        str = str.substring(str.indexOf("/") + 1, str.length());
        CostLevel = Integer.parseInt(str.substring(0, str.indexOf("/")));
        str = str.substring(str.indexOf("/") + 1, str.length());
        level = 0;
        working = true;
        LossOfPopulation = Integer.parseInt(str.substring(0, str.indexOf("/")));
        str = str.substring(str.indexOf("/") + 1, str.length());
        addParameter = str.substring(0, str.indexOf(" "));
        str = str.substring(str.indexOf(" ") + 1, str.length());
        reduce = Integer.parseInt(str.substring(0, str.indexOf(" ")));
        vil = utopaevo;
    }
    //Метод, который изменяет показатели деревни казны каждые 30 секунд.
    public void ChangeIndicatorAndCoffers() {
        if(working == true) {
            for(int i = 0; i < quantityAdd; i++) {
                if(addParam[i] != null) {
                    if(addParam[i].compareTo("Доверие") == 0) {
                        vil.confidence += quanAddParam[i] + quanAddParam[i]*level*CoefficientPar1;
                    }
                    if(addParam[i].compareTo("Здоровье") == 0) {
                        vil.health += quanAddParam[i] + quanAddParam[i]*level*CoefficientPar1;
                    }
                    if(addParam[i].compareTo("Безопасность") == 0) {
                        vil.security += quanAddParam[i] + quanAddParam[i]*level*CoefficientPar1;
                    }
                    if(addParam[i].compareTo("Досуг") == 0) {
                        vil.leisure += quanAddParam[i] + quanAddParam[i]*level*CoefficientPar1;
                    }
                    if(addParam[i].compareTo("Образование") == 0) {
                        vil.education += quanAddParam[i] + quanAddParam[i]*level*CoefficientPar1;
                    }
                    if(addParam[i].compareTo("Занятость") == 0) {
                        vil.employment += quanAddParam[i] + quanAddParam[i]*level*CoefficientPar1;
                    }
                    if(addParam[i].compareTo("Потребность") == 0) {
                        vil.need += quanAddParam[i] + quanAddParam[i]*level*CoefficientPar1;
                    }
                }
            }
            for(int i = 0; i < quantityDec; i++) {
                if(decParam[i] != null) {
                    if(decParam[i].compareTo("Доверие") == 0) {
                        vil.confidence -= (quanDecParam[i] - quanAddParam[i]*level*CoefficientPar1);
                    }
                    if(decParam[i].compareTo("Здоровье") == 0) {
                        vil.health -= (quanDecParam[i] - quanAddParam[i]*level*CoefficientPar1);
                    }
                    if(decParam[i].compareTo("Безопасность") == 0) {
                        vil.security -= (quanDecParam[i] - quanAddParam[i]*level*CoefficientPar1);
                    }
                    if(decParam[i].compareTo("Досуг") == 0) {
                        vil.leisure -= (quanDecParam[i] - quanAddParam[i]*level*CoefficientPar1);
                    }
                    if(decParam[i].compareTo("Образование") == 0) {
                        vil.education -= (quanDecParam[i] - quanAddParam[i]*level*CoefficientPar1);
                    }
                    if(decParam[i].compareTo("Занятость") == 0) {
                        vil.employment -= (quanDecParam[i] - quanAddParam[i]*level*CoefficientPar1);
                    }
                    if(decParam[i].compareTo("Потребность") == 0) {
                        vil.need -= (quanDecParam[i] - quanAddParam[i]*level*CoefficientPar1);
                    }
                }
            }
            vil.coffers += profit + level*profit*CoefficientPar3;
            vil.coffers -= (wane - level*wane*CoefficientPar1); 
        }
        else {
            for(int i = 0; i < quantityAdd; i++) {
                if(addParam[i] != null) {
                    if(addParam[i].compareTo("Доверие") == 0) {
                        vil.confidence -= (quanAddParam[i] - quanAddParam[i]*level*CoefficientPar1);
                    }
                    if(addParam[i].compareTo("Здоровье") == 0) {
                        vil.health -= (quanAddParam[i] - quanAddParam[i]*level*CoefficientPar1);
                    }
                    if(addParam[i].compareTo("Безопасность") == 0) {
                        vil.security -= (quanAddParam[i] - quanAddParam[i]*level*CoefficientPar1) ;
                    }
                    if(addParam[i].compareTo("Досуг") == 0) {
                        vil.leisure -= (quanAddParam[i] - quanAddParam[i]*level*CoefficientPar1);
                    }
                    if(addParam[i].compareTo("Образование") == 0) {
                        vil.education -= (quanAddParam[i] - quanAddParam[i]*level*CoefficientPar1);
                    }
                    if(addParam[i].compareTo("Занятость") == 0) {
                        vil.employment -= (quanAddParam[i] - quanAddParam[i]*level*CoefficientPar1);
                    }
                    if(addParam[i].compareTo("Потребность") == 0) {
                        vil.need -= (quanAddParam[i] - - quanAddParam[i]*level*CoefficientPar1);
                    }
                }
            }
            vil.population -= vil.population * LossOfPopulation*CoefficientPar2;
            if(addParameter.compareTo("Доверие") == 0) {
                vil.confidence -= (reduce - reduce*level*CoefficientPar1);
            }
            if(addParameter.compareTo("Здоровье") == 0) {
                vil.health -= (reduce - reduce*level*CoefficientPar1);
            }
            if(addParameter.compareTo("Безопасность") == 0) {
                vil.security -= (reduce - reduce*level*CoefficientPar1);
            }
            if(addParameter.compareTo("Досуг") == 0) {
                vil.leisure -= (reduce - reduce*level*CoefficientPar1);
            }
            if(addParameter.compareTo("Образование") == 0) {
                vil.education -= (reduce - reduce*level*CoefficientPar1);
            }
            if(addParameter.compareTo("Занятость") == 0) {
                vil.employment -= (reduce - reduce*level*CoefficientPar1);
            }
            if(addParameter.compareTo("Потребность") == 0) {
                vil.need -= (reduce - reduce*level*CoefficientPar1);
            }
        }
    }    
}
