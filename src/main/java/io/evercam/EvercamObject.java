package io.evercam;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class EvercamObject
{
    static final int CODE_OK = 200;
    static final int CODE_CREATE = 201;
    static final int CODE_UNAUTHORISED = 401;
    static final int CODE_FORBIDDEN = 403;
    static final int CODE_ERROR = 400;
    static final int CODE_NOT_FOUND = 404;
    static final int CODE_SERVER_ERROR = 500;

    final String RTSP_PREFIX = "rtsp://";
    final String HTTP_PREFIX = "http://";

    JSONObject jsonObject;

    protected JSONObject getJsonObjectByString(String key) throws EvercamException
    {
        try
        {
            return jsonObject.getJSONObject(key);
        } catch (JSONException e)
        {
            throw new EvercamException(e);
        }
    }

    protected JSONArray getJsonArrayByString(String key) throws EvercamException
    {
        try
        {
            return jsonObject.getJSONArray(key);
        } catch (JSONException e)
        {
            throw new EvercamException(e);
        }
    }

    @Override
    public String toString()
    {
        return String.format("<%s@%s id=%s> JSON: %s", this.getClass().getName(), System.identityHashCode(this), this.getIdString(), jsonObject.toString());
    }

    private Object getIdString()
    {
        try
        {
            return jsonObject.getString("id");
        } catch (SecurityException e)
        {
            return "";
        } catch (JSONException e)
        {
            return "";
        }
    }
}
