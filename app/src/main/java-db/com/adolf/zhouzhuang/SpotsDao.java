package com.adolf.zhouzhuang;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.adolf.zhouzhuang.Spots;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "spots".
*/
public class SpotsDao extends AbstractDao<Spots, Long> {

    public static final String TABLENAME = "spots";

    /**
     * Properties of entity Spots.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Pid = new Property(1, int.class, "userId", false, "PID");
        public final static Property Order = new Property(2, Integer.class, "order", false, "ORDER");
        public final static Property CreateTime = new Property(3, Long.class, "createTime", false, "CREATE_TIME");
        public final static Property Title = new Property(4, String.class, "title", false, "TITLE");
        public final static Property Brief = new Property(5, String.class, "brief", false, "BRIEF");
        public final static Property DetailUrl = new Property(6, String.class, "detailUrl", false, "DETAIL_URL");
        public final static Property Lat = new Property(7, String.class, "lat", false, "LAT");
        public final static Property Lng = new Property(8, String.class, "lng", false, "LNG");
        public final static Property VideoLocation = new Property(9, String.class, "videoLocation", false, "VIDEO_LOCATION");
        public final static Property VideoVersion = new Property(10, Integer.class, "videoVersion", false, "VIDEO_VERSION");
        public final static Property BasicInfoVersion = new Property(11, Integer.class, "basicInfoVersion", false, "BASIC_INFO_VERSION");
        public final static Property IsDownLoadAudio = new Property(12, Boolean.class, "isDownLoadAudio", false, "IS_DOWN_LOAD_AUDIO");
        public final static Property IsFavorite = new Property(13, Boolean.class, "isFavorite", false, "IS_FAVORITE");
    };


    public SpotsDao(DaoConfig config) {
        super(config);
    }
    
    public SpotsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"spots\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"PID\" INTEGER NOT NULL ," + // 1: userId
                "\"ORDER\" INTEGER," + // 2: order
                "\"CREATE_TIME\" INTEGER," + // 3: createTime
                "\"TITLE\" TEXT," + // 4: title
                "\"BRIEF\" TEXT," + // 5: brief
                "\"DETAIL_URL\" TEXT," + // 6: detailUrl
                "\"LAT\" TEXT," + // 7: lat
                "\"LNG\" TEXT," + // 8: lng
                "\"VIDEO_LOCATION\" TEXT," + // 9: videoLocation
                "\"VIDEO_VERSION\" INTEGER," + // 10: videoVersion
                "\"BASIC_INFO_VERSION\" INTEGER," + // 11: basicInfoVersion
                "\"IS_DOWN_LOAD_AUDIO\" INTEGER," + // 12: isDownLoadAudio
                "\"IS_FAVORITE\" INTEGER);"); // 13: isFavorite
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"spots\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Spots entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getPid());
 
        Integer order = entity.getOrder();
        if (order != null) {
            stmt.bindLong(3, order);
        }
 
        Long createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(4, createTime);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(5, title);
        }
 
        String brief = entity.getBrief();
        if (brief != null) {
            stmt.bindString(6, brief);
        }
 
        String detailUrl = entity.getDetailUrl();
        if (detailUrl != null) {
            stmt.bindString(7, detailUrl);
        }
 
        String lat = entity.getLat();
        if (lat != null) {
            stmt.bindString(8, lat);
        }
 
        String lng = entity.getLng();
        if (lng != null) {
            stmt.bindString(9, lng);
        }
 
        String videoLocation = entity.getVideoLocation();
        if (videoLocation != null) {
            stmt.bindString(10, videoLocation);
        }
 
        Integer videoVersion = entity.getVideoVersion();
        if (videoVersion != null) {
            stmt.bindLong(11, videoVersion);
        }
 
        Integer basicInfoVersion = entity.getBasicInfoVersion();
        if (basicInfoVersion != null) {
            stmt.bindLong(12, basicInfoVersion);
        }
 
        Boolean isDownLoadAudio = entity.getIsDownLoadAudio();
        if (isDownLoadAudio != null) {
            stmt.bindLong(13, isDownLoadAudio ? 1L: 0L);
        }
 
        Boolean isFavorite = entity.getIsFavorite();
        if (isFavorite != null) {
            stmt.bindLong(14, isFavorite ? 1L: 0L);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Spots readEntity(Cursor cursor, int offset) {
        Spots entity = new Spots( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // userId
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // order
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // createTime
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // title
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // brief
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // detailUrl
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // lat
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // lng
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // videoLocation
            cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10), // videoVersion
            cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11), // basicInfoVersion
            cursor.isNull(offset + 12) ? null : cursor.getShort(offset + 12) != 0, // isDownLoadAudio
            cursor.isNull(offset + 13) ? null : cursor.getShort(offset + 13) != 0 // isFavorite
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Spots entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPid(cursor.getInt(offset + 1));
        entity.setOrder(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setCreateTime(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setTitle(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setBrief(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setDetailUrl(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setLat(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setLng(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setVideoLocation(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setVideoVersion(cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10));
        entity.setBasicInfoVersion(cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11));
        entity.setIsDownLoadAudio(cursor.isNull(offset + 12) ? null : cursor.getShort(offset + 12) != 0);
        entity.setIsFavorite(cursor.isNull(offset + 13) ? null : cursor.getShort(offset + 13) != 0);
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Spots entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Spots entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
