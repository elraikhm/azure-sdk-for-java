/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 * 
 * Code generated by Microsoft (R) AutoRest Code Generator 0.11.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package fixtures.http;

import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceException;
import retrofit.Call;
import com.squareup.okhttp.ResponseBody;
import java.util.List;
import retrofit.http.HEAD;
import retrofit.http.GET;
import retrofit.http.PUT;
import retrofit.http.Body;
import retrofit.http.PATCH;
import retrofit.http.POST;
import retrofit.http.HTTP;

/**
 * An instance of this class provides access to all the operations defined
 * in HttpRedirects.
 */
public interface HttpRedirects {
    /**
     * The interface defining all the services for HttpRedirects to be
     * used by Retrofit to perform actually REST calls.
     */
    interface HttpRedirectsService {
        @HEAD("/http/redirect/300")
        Call<Void> head300();

        @GET("/http/redirect/300")
        Call<ResponseBody> get300();

        @HEAD("/http/redirect/301")
        Call<Void> head301();

        @GET("/http/redirect/301")
        Call<ResponseBody> get301();

        @PUT("/http/redirect/301")
        Call<ResponseBody> put301(@Body Boolean booleanValue);

        @HEAD("/http/redirect/302")
        Call<Void> head302();

        @GET("/http/redirect/302")
        Call<ResponseBody> get302();

        @PATCH("/http/redirect/302")
        Call<ResponseBody> patch302(@Body Boolean booleanValue);

        @POST("/http/redirect/303")
        Call<ResponseBody> post303(@Body Boolean booleanValue);

        @HEAD("/http/redirect/307")
        Call<Void> head307();

        @GET("/http/redirect/307")
        Call<ResponseBody> get307();

        @PUT("/http/redirect/307")
        Call<ResponseBody> put307(@Body Boolean booleanValue);

        @PATCH("/http/redirect/307")
        Call<ResponseBody> patch307(@Body Boolean booleanValue);

        @POST("/http/redirect/307")
        Call<ResponseBody> post307(@Body Boolean booleanValue);

        @HTTP(path = "/http/redirect/307", method = "DELETE", hasBody = true)
        Call<ResponseBody> delete307(@Body Boolean booleanValue);

    }
    /**
     *
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    void head300() throws ServiceException;

    /**
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<Void> head300Async(final ServiceCallback<Void> serviceCallback);

    /**
     *
     * @return the List&lt;String&gt; object if successful.
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    List<String> get300() throws ServiceException;

    /**
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> get300Async(final ServiceCallback<List<String>> serviceCallback);

    /**
     *
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    void head301() throws ServiceException;

    /**
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<Void> head301Async(final ServiceCallback<Void> serviceCallback);

    /**
     *
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    void get301() throws ServiceException;

    /**
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> get301Async(final ServiceCallback<Void> serviceCallback);

    /**
     *
     * @param booleanValue Simple boolean value true
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    void put301(Boolean booleanValue) throws ServiceException;

    /**
     *
     * @param booleanValue Simple boolean value true
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> put301Async(Boolean booleanValue, final ServiceCallback<Void> serviceCallback);

    /**
     *
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    void head302() throws ServiceException;

    /**
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<Void> head302Async(final ServiceCallback<Void> serviceCallback);

    /**
     *
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    void get302() throws ServiceException;

    /**
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> get302Async(final ServiceCallback<Void> serviceCallback);

    /**
     *
     * @param booleanValue Simple boolean value true
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    void patch302(Boolean booleanValue) throws ServiceException;

    /**
     *
     * @param booleanValue Simple boolean value true
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> patch302Async(Boolean booleanValue, final ServiceCallback<Void> serviceCallback);

    /**
     *
     * @param booleanValue Simple boolean value true
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    void post303(Boolean booleanValue) throws ServiceException;

    /**
     *
     * @param booleanValue Simple boolean value true
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> post303Async(Boolean booleanValue, final ServiceCallback<Void> serviceCallback);

    /**
     *
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    void head307() throws ServiceException;

    /**
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<Void> head307Async(final ServiceCallback<Void> serviceCallback);

    /**
     *
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    void get307() throws ServiceException;

    /**
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> get307Async(final ServiceCallback<Void> serviceCallback);

    /**
     *
     * @param booleanValue Simple boolean value true
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    void put307(Boolean booleanValue) throws ServiceException;

    /**
     *
     * @param booleanValue Simple boolean value true
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> put307Async(Boolean booleanValue, final ServiceCallback<Void> serviceCallback);

    /**
     *
     * @param booleanValue Simple boolean value true
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    void patch307(Boolean booleanValue) throws ServiceException;

    /**
     *
     * @param booleanValue Simple boolean value true
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> patch307Async(Boolean booleanValue, final ServiceCallback<Void> serviceCallback);

    /**
     *
     * @param booleanValue Simple boolean value true
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    void post307(Boolean booleanValue) throws ServiceException;

    /**
     *
     * @param booleanValue Simple boolean value true
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> post307Async(Boolean booleanValue, final ServiceCallback<Void> serviceCallback);

    /**
     *
     * @param booleanValue Simple boolean value true
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    void delete307(Boolean booleanValue) throws ServiceException;

    /**
     *
     * @param booleanValue Simple boolean value true
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> delete307Async(Boolean booleanValue, final ServiceCallback<Void> serviceCallback);

}
