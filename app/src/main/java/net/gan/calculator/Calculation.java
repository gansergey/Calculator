package net.gan.calculator;

import android.os.Parcel;
import android.os.Parcelable;

public class Calculation implements Parcelable {

    private boolean firsOrSecondNumber;

    private boolean permissionEnterOperation;
    private boolean permissionEnterResult;

    private StringBuilder number1;
    private StringBuilder number2;
    private StringBuilder infoActionOnDisplay;

    private String activeOperation;
    private String lastResult; //Нужно для сохранения данных результата Parcelable

    public Calculation() {
        clear();
    }

    protected Calculation(Parcel in) {
        firsOrSecondNumber = in.readByte() != 0;
        permissionEnterOperation = in.readByte() != 0;
        permissionEnterResult = in.readByte() != 0;
        activeOperation = in.readString();
    }

    public static final Creator<Calculation> CREATOR = new Creator<Calculation>() {
        @Override
        public Calculation createFromParcel(Parcel in) {
            return new Calculation(in);
        }

        @Override
        public Calculation[] newArray(int size) {
            return new Calculation[size];
        }
    };

    public void numberClick(String number) {

        if (firsOrSecondNumber) {
            number1.append(number);
            permissionEnterOperation = true; //Разрешаем вводить знак операции
        } else {
            number2.append(number);
            permissionEnterResult = true; //Разрешаем вычислять результат после ввода второго числа
        }
        infoActionOnDisplay.append(number);
    }

    public void operationClick(String operation) {
        if (permissionEnterOperation) {
            firsOrSecondNumber = false; //После операции по условию заполняем второе число
            activeOperation = operation;
            infoActionOnDisplay.append(operation);
        }
        setDefaultValue();
        permissionEnterOperation = false;//Блокируем внесении операции до ввода числа
    }

    public String getInfo() {
        if (infoActionOnDisplay.length() == 0) {
            return lastResult;
        } else {
            return infoActionOnDisplay.toString();
        }
    }

    public void calculateResult() {
        float result;
        if (permissionEnterResult) {
            switch (activeOperation) {
                case ("/"):
                    result = Float.parseFloat(number1.toString()) / Float.parseFloat(number2.toString());
                    break;
                case "*":
                    result = Float.parseFloat(number1.toString()) * Float.parseFloat(number2.toString());
                    break;
                case "+":
                    result = Float.parseFloat(number1.toString()) + Float.parseFloat(number2.toString());
                    break;
                case "-":
                    result = Float.parseFloat(number1.toString()) - Float.parseFloat(number2.toString());
                    break;
                default:
                    result = 0;
                    break;
            }
            infoActionOnDisplay.append("=" + "\n");
            infoActionOnDisplay.append(result);
            lastResult = infoActionOnDisplay.toString();
        }
    }

    public void clear() {
        number1 = new StringBuilder();
        number2 = new StringBuilder();
        infoActionOnDisplay = new StringBuilder();
        firsOrSecondNumber = true;//По условию true начинаем заполнение первого числа
        permissionEnterOperation = false;//По услови false запрещаем ставить знаки операций
        permissionEnterResult = false;//Запрещаем вычислять результат пока не ввели второе число
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (firsOrSecondNumber ? 1 : 0));
        dest.writeByte((byte) (permissionEnterOperation ? 1 : 0));
        dest.writeByte((byte) (permissionEnterResult ? 1 : 0));
        dest.writeString(activeOperation);
    }

    public void setDefaultValue() {
        lastResult = "0";
    }
}