package yea.data.remote;

import org.greenrobot.eventbus.EventBus;

import yea.MyApplication;
import yea.data.events.BaseEvent;
import yea.data.events.EmptyEvent;
import yea.data.events.ErrorEvent;
import yea.utils.constants.I;
import retrofit2.Response;

/**
 * Created by bukhoriaqid on 11/12/16.
 */

abstract class BaseAPI
{
    MyApplication app   = MyApplication.getInstance();
    EventBus      event = EventBus.getDefault();

    EmptyEvent mEmptyEvent = new EmptyEvent();

    void handleResponse (Response response, BaseEvent eventClass)
    {
        if (response.isSuccessful())
        {
            if (response.code() == I.HTTP_NO_CONTENT)
            {
                event.post(mEmptyEvent);
            }
            else
            {
                event.post(eventClass);
            }
        }
        else
        {
            event.post(new ErrorEvent(response));
        }
    }
}
