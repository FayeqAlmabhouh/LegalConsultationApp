package com.example.legalconsultationapp.Constant;

public class ConstantVariable {

    private final String SHARED_PREF_NAME = "User Profile Dat";
    private final String key_User_Email = "Email";
    private final String key_User_Name = "Name";
    private final String key_User_PhoneNumper = "phoneNumper";
    private final String DB_UserName = "UserName";
    private final String DB_UserEmail = "Email";
    private final String DB_UserPhoneNumber = "PhoneNumber";
    private final String DB_RootName = "Users";
    private final String passSendeItToEmail = "تم أرسال أعدادات كلمة اسر الى الايميل ";
    private final String empty_email = "البريد الإكتروني مطلوب";
    private final String empty_password = "كلمة السر مطلوبة";
    private final String noInternet = "لا يوجد أتصال بالإنترنت تحقق من الشبكة";
    private final String DB_UserID = "ID";
    private final String updateSuccess = "تم تحديث البينات بنجاح";


    public String getUpdateSuccess() {
        return updateSuccess;
    }

    public String getPassSendeItToEmail() {
        return passSendeItToEmail;
    }

    public String getDB_RootName() {
        return DB_RootName;
    }

    public String getDB_UserID() {
        return DB_UserID;
    }



    public String getNoInternet() {
        return noInternet;
    }

    public String getEmpty_email() {
        return empty_email;
    }

    public String getEmpty_password() {
        return empty_password;
    }

    public String getDB_UserName() {
        return DB_UserName;
    }

    public String getDB_UserEmail() {
        return DB_UserEmail;
    }

    public String getDB_UserPhoneNumber() {
        return DB_UserPhoneNumber;
    }

    public String getSHARED_PREF_NAME() {
        return SHARED_PREF_NAME;
    }

    public String getKey_User_Email() {
        return key_User_Email;
    }

    public String getKey_User_Name() {
        return key_User_Name;
    }

    public String getKey_User_PhoneNumper() {
        return key_User_PhoneNumper;
    }
}
