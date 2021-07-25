public class Validator {


    public Validator(){};

    public boolean argsEven(String[] args) {
        return args.length % 2 != 0;
    }

    public boolean argsCount(String[] args){
        return args.length>=3;
    }

}
