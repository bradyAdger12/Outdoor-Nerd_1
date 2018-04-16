package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class DataWRealmProxy extends edu.western.cs.outdoornerd.models.DataW
    implements RealmObjectProxy, DataWRealmProxyInterface {

    static final class DataWColumnInfo extends ColumnInfo {
        long idIndex;
        long stationNameIndex;
        long tripletIndex;
        long dateTimeIndex;
        long tempIndex;
        long windAIndex;
        long snowDIndex;
        long waterEqIndex;

        DataWColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("DataW");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.stationNameIndex = addColumnDetails("stationName", objectSchemaInfo);
            this.tripletIndex = addColumnDetails("triplet", objectSchemaInfo);
            this.dateTimeIndex = addColumnDetails("dateTime", objectSchemaInfo);
            this.tempIndex = addColumnDetails("temp", objectSchemaInfo);
            this.windAIndex = addColumnDetails("windA", objectSchemaInfo);
            this.snowDIndex = addColumnDetails("snowD", objectSchemaInfo);
            this.waterEqIndex = addColumnDetails("waterEq", objectSchemaInfo);
        }

        DataWColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new DataWColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final DataWColumnInfo src = (DataWColumnInfo) rawSrc;
            final DataWColumnInfo dst = (DataWColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.stationNameIndex = src.stationNameIndex;
            dst.tripletIndex = src.tripletIndex;
            dst.dateTimeIndex = src.dateTimeIndex;
            dst.tempIndex = src.tempIndex;
            dst.windAIndex = src.windAIndex;
            dst.snowDIndex = src.snowDIndex;
            dst.waterEqIndex = src.waterEqIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(8);
        fieldNames.add("id");
        fieldNames.add("stationName");
        fieldNames.add("triplet");
        fieldNames.add("dateTime");
        fieldNames.add("temp");
        fieldNames.add("windA");
        fieldNames.add("snowD");
        fieldNames.add("waterEq");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private DataWColumnInfo columnInfo;
    private ProxyState<edu.western.cs.outdoornerd.models.DataW> proxyState;

    DataWRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DataWColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<edu.western.cs.outdoornerd.models.DataW>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$stationName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.stationNameIndex);
    }

    @Override
    public void realmSet$stationName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.stationNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.stationNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.stationNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.stationNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$triplet() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.tripletIndex);
    }

    @Override
    public void realmSet$triplet(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.tripletIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.tripletIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.tripletIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.tripletIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$dateTime() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.dateTimeIndex);
    }

    @Override
    public void realmSet$dateTime(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.dateTimeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.dateTimeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.dateTimeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.dateTimeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$temp() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.tempIndex);
    }

    @Override
    public void realmSet$temp(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.tempIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.tempIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.tempIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.tempIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$windA() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.windAIndex);
    }

    @Override
    public void realmSet$windA(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.windAIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.windAIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.windAIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.windAIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$snowD() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.snowDIndex);
    }

    @Override
    public void realmSet$snowD(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.snowDIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.snowDIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.snowDIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.snowDIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$waterEq() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.waterEqIndex);
    }

    @Override
    public void realmSet$waterEq(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.waterEqIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.waterEqIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.waterEqIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.waterEqIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("DataW", 8, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("stationName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("triplet", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("dateTime", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("temp", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("windA", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("snowD", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("waterEq", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static DataWColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new DataWColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "DataW";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static edu.western.cs.outdoornerd.models.DataW createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        edu.western.cs.outdoornerd.models.DataW obj = null;
        if (update) {
            Table table = realm.getTable(edu.western.cs.outdoornerd.models.DataW.class);
            DataWColumnInfo columnInfo = (DataWColumnInfo) realm.getSchema().getColumnInfo(edu.western.cs.outdoornerd.models.DataW.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(edu.western.cs.outdoornerd.models.DataW.class), false, Collections.<String> emptyList());
                    obj = new io.realm.DataWRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.DataWRealmProxy) realm.createObjectInternal(edu.western.cs.outdoornerd.models.DataW.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.DataWRealmProxy) realm.createObjectInternal(edu.western.cs.outdoornerd.models.DataW.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final DataWRealmProxyInterface objProxy = (DataWRealmProxyInterface) obj;
        if (json.has("stationName")) {
            if (json.isNull("stationName")) {
                objProxy.realmSet$stationName(null);
            } else {
                objProxy.realmSet$stationName((String) json.getString("stationName"));
            }
        }
        if (json.has("triplet")) {
            if (json.isNull("triplet")) {
                objProxy.realmSet$triplet(null);
            } else {
                objProxy.realmSet$triplet((String) json.getString("triplet"));
            }
        }
        if (json.has("dateTime")) {
            if (json.isNull("dateTime")) {
                objProxy.realmSet$dateTime(null);
            } else {
                objProxy.realmSet$dateTime((String) json.getString("dateTime"));
            }
        }
        if (json.has("temp")) {
            if (json.isNull("temp")) {
                objProxy.realmSet$temp(null);
            } else {
                objProxy.realmSet$temp((String) json.getString("temp"));
            }
        }
        if (json.has("windA")) {
            if (json.isNull("windA")) {
                objProxy.realmSet$windA(null);
            } else {
                objProxy.realmSet$windA((String) json.getString("windA"));
            }
        }
        if (json.has("snowD")) {
            if (json.isNull("snowD")) {
                objProxy.realmSet$snowD(null);
            } else {
                objProxy.realmSet$snowD((String) json.getString("snowD"));
            }
        }
        if (json.has("waterEq")) {
            if (json.isNull("waterEq")) {
                objProxy.realmSet$waterEq(null);
            } else {
                objProxy.realmSet$waterEq((String) json.getString("waterEq"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static edu.western.cs.outdoornerd.models.DataW createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final edu.western.cs.outdoornerd.models.DataW obj = new edu.western.cs.outdoornerd.models.DataW();
        final DataWRealmProxyInterface objProxy = (DataWRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("stationName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$stationName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$stationName(null);
                }
            } else if (name.equals("triplet")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$triplet((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$triplet(null);
                }
            } else if (name.equals("dateTime")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$dateTime((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$dateTime(null);
                }
            } else if (name.equals("temp")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$temp((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$temp(null);
                }
            } else if (name.equals("windA")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$windA((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$windA(null);
                }
            } else if (name.equals("snowD")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$snowD((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$snowD(null);
                }
            } else if (name.equals("waterEq")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$waterEq((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$waterEq(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static edu.western.cs.outdoornerd.models.DataW copyOrUpdate(Realm realm, edu.western.cs.outdoornerd.models.DataW object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (edu.western.cs.outdoornerd.models.DataW) cachedRealmObject;
        }

        edu.western.cs.outdoornerd.models.DataW realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(edu.western.cs.outdoornerd.models.DataW.class);
            DataWColumnInfo columnInfo = (DataWColumnInfo) realm.getSchema().getColumnInfo(edu.western.cs.outdoornerd.models.DataW.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((DataWRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(edu.western.cs.outdoornerd.models.DataW.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.DataWRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static edu.western.cs.outdoornerd.models.DataW copy(Realm realm, edu.western.cs.outdoornerd.models.DataW newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (edu.western.cs.outdoornerd.models.DataW) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        edu.western.cs.outdoornerd.models.DataW realmObject = realm.createObjectInternal(edu.western.cs.outdoornerd.models.DataW.class, ((DataWRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        DataWRealmProxyInterface realmObjectSource = (DataWRealmProxyInterface) newObject;
        DataWRealmProxyInterface realmObjectCopy = (DataWRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$stationName(realmObjectSource.realmGet$stationName());
        realmObjectCopy.realmSet$triplet(realmObjectSource.realmGet$triplet());
        realmObjectCopy.realmSet$dateTime(realmObjectSource.realmGet$dateTime());
        realmObjectCopy.realmSet$temp(realmObjectSource.realmGet$temp());
        realmObjectCopy.realmSet$windA(realmObjectSource.realmGet$windA());
        realmObjectCopy.realmSet$snowD(realmObjectSource.realmGet$snowD());
        realmObjectCopy.realmSet$waterEq(realmObjectSource.realmGet$waterEq());
        return realmObject;
    }

    public static long insert(Realm realm, edu.western.cs.outdoornerd.models.DataW object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(edu.western.cs.outdoornerd.models.DataW.class);
        long tableNativePtr = table.getNativePtr();
        DataWColumnInfo columnInfo = (DataWColumnInfo) realm.getSchema().getColumnInfo(edu.western.cs.outdoornerd.models.DataW.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((DataWRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((DataWRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((DataWRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$stationName = ((DataWRealmProxyInterface) object).realmGet$stationName();
        if (realmGet$stationName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stationNameIndex, rowIndex, realmGet$stationName, false);
        }
        String realmGet$triplet = ((DataWRealmProxyInterface) object).realmGet$triplet();
        if (realmGet$triplet != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tripletIndex, rowIndex, realmGet$triplet, false);
        }
        String realmGet$dateTime = ((DataWRealmProxyInterface) object).realmGet$dateTime();
        if (realmGet$dateTime != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateTimeIndex, rowIndex, realmGet$dateTime, false);
        }
        String realmGet$temp = ((DataWRealmProxyInterface) object).realmGet$temp();
        if (realmGet$temp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tempIndex, rowIndex, realmGet$temp, false);
        }
        String realmGet$windA = ((DataWRealmProxyInterface) object).realmGet$windA();
        if (realmGet$windA != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.windAIndex, rowIndex, realmGet$windA, false);
        }
        String realmGet$snowD = ((DataWRealmProxyInterface) object).realmGet$snowD();
        if (realmGet$snowD != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.snowDIndex, rowIndex, realmGet$snowD, false);
        }
        String realmGet$waterEq = ((DataWRealmProxyInterface) object).realmGet$waterEq();
        if (realmGet$waterEq != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.waterEqIndex, rowIndex, realmGet$waterEq, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(edu.western.cs.outdoornerd.models.DataW.class);
        long tableNativePtr = table.getNativePtr();
        DataWColumnInfo columnInfo = (DataWColumnInfo) realm.getSchema().getColumnInfo(edu.western.cs.outdoornerd.models.DataW.class);
        long pkColumnIndex = columnInfo.idIndex;
        edu.western.cs.outdoornerd.models.DataW object = null;
        while (objects.hasNext()) {
            object = (edu.western.cs.outdoornerd.models.DataW) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((DataWRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((DataWRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((DataWRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$stationName = ((DataWRealmProxyInterface) object).realmGet$stationName();
            if (realmGet$stationName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.stationNameIndex, rowIndex, realmGet$stationName, false);
            }
            String realmGet$triplet = ((DataWRealmProxyInterface) object).realmGet$triplet();
            if (realmGet$triplet != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tripletIndex, rowIndex, realmGet$triplet, false);
            }
            String realmGet$dateTime = ((DataWRealmProxyInterface) object).realmGet$dateTime();
            if (realmGet$dateTime != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.dateTimeIndex, rowIndex, realmGet$dateTime, false);
            }
            String realmGet$temp = ((DataWRealmProxyInterface) object).realmGet$temp();
            if (realmGet$temp != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tempIndex, rowIndex, realmGet$temp, false);
            }
            String realmGet$windA = ((DataWRealmProxyInterface) object).realmGet$windA();
            if (realmGet$windA != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.windAIndex, rowIndex, realmGet$windA, false);
            }
            String realmGet$snowD = ((DataWRealmProxyInterface) object).realmGet$snowD();
            if (realmGet$snowD != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.snowDIndex, rowIndex, realmGet$snowD, false);
            }
            String realmGet$waterEq = ((DataWRealmProxyInterface) object).realmGet$waterEq();
            if (realmGet$waterEq != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.waterEqIndex, rowIndex, realmGet$waterEq, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, edu.western.cs.outdoornerd.models.DataW object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(edu.western.cs.outdoornerd.models.DataW.class);
        long tableNativePtr = table.getNativePtr();
        DataWColumnInfo columnInfo = (DataWColumnInfo) realm.getSchema().getColumnInfo(edu.western.cs.outdoornerd.models.DataW.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((DataWRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((DataWRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((DataWRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$stationName = ((DataWRealmProxyInterface) object).realmGet$stationName();
        if (realmGet$stationName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stationNameIndex, rowIndex, realmGet$stationName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.stationNameIndex, rowIndex, false);
        }
        String realmGet$triplet = ((DataWRealmProxyInterface) object).realmGet$triplet();
        if (realmGet$triplet != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tripletIndex, rowIndex, realmGet$triplet, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tripletIndex, rowIndex, false);
        }
        String realmGet$dateTime = ((DataWRealmProxyInterface) object).realmGet$dateTime();
        if (realmGet$dateTime != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateTimeIndex, rowIndex, realmGet$dateTime, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dateTimeIndex, rowIndex, false);
        }
        String realmGet$temp = ((DataWRealmProxyInterface) object).realmGet$temp();
        if (realmGet$temp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tempIndex, rowIndex, realmGet$temp, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tempIndex, rowIndex, false);
        }
        String realmGet$windA = ((DataWRealmProxyInterface) object).realmGet$windA();
        if (realmGet$windA != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.windAIndex, rowIndex, realmGet$windA, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.windAIndex, rowIndex, false);
        }
        String realmGet$snowD = ((DataWRealmProxyInterface) object).realmGet$snowD();
        if (realmGet$snowD != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.snowDIndex, rowIndex, realmGet$snowD, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.snowDIndex, rowIndex, false);
        }
        String realmGet$waterEq = ((DataWRealmProxyInterface) object).realmGet$waterEq();
        if (realmGet$waterEq != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.waterEqIndex, rowIndex, realmGet$waterEq, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.waterEqIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(edu.western.cs.outdoornerd.models.DataW.class);
        long tableNativePtr = table.getNativePtr();
        DataWColumnInfo columnInfo = (DataWColumnInfo) realm.getSchema().getColumnInfo(edu.western.cs.outdoornerd.models.DataW.class);
        long pkColumnIndex = columnInfo.idIndex;
        edu.western.cs.outdoornerd.models.DataW object = null;
        while (objects.hasNext()) {
            object = (edu.western.cs.outdoornerd.models.DataW) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((DataWRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((DataWRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((DataWRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$stationName = ((DataWRealmProxyInterface) object).realmGet$stationName();
            if (realmGet$stationName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.stationNameIndex, rowIndex, realmGet$stationName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.stationNameIndex, rowIndex, false);
            }
            String realmGet$triplet = ((DataWRealmProxyInterface) object).realmGet$triplet();
            if (realmGet$triplet != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tripletIndex, rowIndex, realmGet$triplet, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.tripletIndex, rowIndex, false);
            }
            String realmGet$dateTime = ((DataWRealmProxyInterface) object).realmGet$dateTime();
            if (realmGet$dateTime != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.dateTimeIndex, rowIndex, realmGet$dateTime, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.dateTimeIndex, rowIndex, false);
            }
            String realmGet$temp = ((DataWRealmProxyInterface) object).realmGet$temp();
            if (realmGet$temp != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tempIndex, rowIndex, realmGet$temp, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.tempIndex, rowIndex, false);
            }
            String realmGet$windA = ((DataWRealmProxyInterface) object).realmGet$windA();
            if (realmGet$windA != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.windAIndex, rowIndex, realmGet$windA, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.windAIndex, rowIndex, false);
            }
            String realmGet$snowD = ((DataWRealmProxyInterface) object).realmGet$snowD();
            if (realmGet$snowD != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.snowDIndex, rowIndex, realmGet$snowD, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.snowDIndex, rowIndex, false);
            }
            String realmGet$waterEq = ((DataWRealmProxyInterface) object).realmGet$waterEq();
            if (realmGet$waterEq != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.waterEqIndex, rowIndex, realmGet$waterEq, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.waterEqIndex, rowIndex, false);
            }
        }
    }

    public static edu.western.cs.outdoornerd.models.DataW createDetachedCopy(edu.western.cs.outdoornerd.models.DataW realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        edu.western.cs.outdoornerd.models.DataW unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new edu.western.cs.outdoornerd.models.DataW();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (edu.western.cs.outdoornerd.models.DataW) cachedObject.object;
            }
            unmanagedObject = (edu.western.cs.outdoornerd.models.DataW) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        DataWRealmProxyInterface unmanagedCopy = (DataWRealmProxyInterface) unmanagedObject;
        DataWRealmProxyInterface realmSource = (DataWRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$stationName(realmSource.realmGet$stationName());
        unmanagedCopy.realmSet$triplet(realmSource.realmGet$triplet());
        unmanagedCopy.realmSet$dateTime(realmSource.realmGet$dateTime());
        unmanagedCopy.realmSet$temp(realmSource.realmGet$temp());
        unmanagedCopy.realmSet$windA(realmSource.realmGet$windA());
        unmanagedCopy.realmSet$snowD(realmSource.realmGet$snowD());
        unmanagedCopy.realmSet$waterEq(realmSource.realmGet$waterEq());

        return unmanagedObject;
    }

    static edu.western.cs.outdoornerd.models.DataW update(Realm realm, edu.western.cs.outdoornerd.models.DataW realmObject, edu.western.cs.outdoornerd.models.DataW newObject, Map<RealmModel, RealmObjectProxy> cache) {
        DataWRealmProxyInterface realmObjectTarget = (DataWRealmProxyInterface) realmObject;
        DataWRealmProxyInterface realmObjectSource = (DataWRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$stationName(realmObjectSource.realmGet$stationName());
        realmObjectTarget.realmSet$triplet(realmObjectSource.realmGet$triplet());
        realmObjectTarget.realmSet$dateTime(realmObjectSource.realmGet$dateTime());
        realmObjectTarget.realmSet$temp(realmObjectSource.realmGet$temp());
        realmObjectTarget.realmSet$windA(realmObjectSource.realmGet$windA());
        realmObjectTarget.realmSet$snowD(realmObjectSource.realmGet$snowD());
        realmObjectTarget.realmSet$waterEq(realmObjectSource.realmGet$waterEq());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("DataW = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{stationName:");
        stringBuilder.append(realmGet$stationName() != null ? realmGet$stationName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{triplet:");
        stringBuilder.append(realmGet$triplet() != null ? realmGet$triplet() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{dateTime:");
        stringBuilder.append(realmGet$dateTime() != null ? realmGet$dateTime() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{temp:");
        stringBuilder.append(realmGet$temp() != null ? realmGet$temp() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{windA:");
        stringBuilder.append(realmGet$windA() != null ? realmGet$windA() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{snowD:");
        stringBuilder.append(realmGet$snowD() != null ? realmGet$snowD() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{waterEq:");
        stringBuilder.append(realmGet$waterEq() != null ? realmGet$waterEq() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataWRealmProxy aDataW = (DataWRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aDataW.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aDataW.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aDataW.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
