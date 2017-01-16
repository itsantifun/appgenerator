package ab.data.remote;

import org.greenrobot.eventbus.EventBus;

import ab.MyApplication;
import ab.data.events.BaseEvent;
import ab.data.events.EmptyEvent;
import ab.data.events.ErrorEvent;
import ab.utils.constants.I;
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
