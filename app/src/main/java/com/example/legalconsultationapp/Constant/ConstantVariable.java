package com.example.legalconsultationapp.Constant;

public class ConstantVariable {
    private final String SHARED_PREF_NAME = "User Profile Dat";
    private final String key_User_Email = "Email";
    private final String key_User_Name = "Name";
    private final String key_User_PhoneNumper = "phoneNumper";
    private final String DB_UserName = "name";
    private final String DB_UserEmail = "email";
    private final String DB_UserPhoneNumber = "phone";
    private final String DB_RootName = "Users";
    private final String DB_UserID =   "userId";
    private final String passSendeItToEmail = "تم أرسال أعدادات كلمة اسر الى الايميل ";
    private final String empty_email = "البريد الإكتروني مطلوب";
    private final String empty_password = "كلمة السر مطلوبة";
    private final String noInternet = "لا يوجد أتصال بالإنترنت تحقق من الشبكة";
    private final String updateSuccess = "تم تحديث البينات بنجاح";
    private final String Password_Length = "الرجاء أدخال كلمة سر أكثر من 6 أحرف";
    private final String Password_Mach = "يجب أن تتطابق كلمتي المرور";
    private final String PasswordChange = "تم تغير كلمة المرور";
    private final String old_Pass_wrong = "أدخل كلمة المرور الحالية خطأ";
    private final String empty_name = " الأسم مطلوب";
    private final String empty_numper = "رقم الجوال مطلوب   ";
    private final String email_formatr = "تحقق من صحة البريد الإلكتروني";
    private final String loading_masg = "الرجاء الانتظار";

    public String getLoading_masg() {
        return loading_masg;
    }

    public String getEmail_formatr() {
        return email_formatr;
    }

    public String getEmpty_name() {
        return empty_name;
    }

    public String getEmpty_numper() {
        return empty_numper;
    }

    public String getOld_Pass_wrong() {
        return old_Pass_wrong;
    }

    public String getPasswordChange() {
        return PasswordChange;
    }

    public String getPassword_Mach() {
        return Password_Mach;
    }

    public String getPassword_Length() {
        return Password_Length;
    }

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
