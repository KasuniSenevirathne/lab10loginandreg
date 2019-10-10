package Database;

import android.provider.BaseColumns;

public final class Usermaster  {
    private Usermaster() {
    }
    public static class  UseEntery implements BaseColumns{
        public static final String TABLE_NAME = "UserTable2";
        public  static final String COL_NAME2 = "Password";
        public static  final String COL_NAME1 = "Name";
        public static final  String COL_NAME3 = "type";

    }
    public  static class MessageEntry implements  BaseColumns{
      public static final String TABLE_NAME1 = "MessageTable2";
      public static final String COL_NAME4 = "User";
      public static final String COL_NAME5 = "Subject";
      public static final String COL_NAME6 = "Message";
    }
}
