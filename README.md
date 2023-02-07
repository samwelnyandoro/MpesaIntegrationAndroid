# MpesaIntegrationAndroid
With the use of this SDK, Android app developers may quickly accept payments through MPESA.
# Screenshots

<p align="center">
  You can use this service for free.
</p>

	
# Features
The following is contained in the SDK:
1. It takes less than 10 lines of code to accept MPESA payments using the native Android SDK.
2. You may easily deploy an example Laravel backend to your server to get going right away.Get it [here](https://github.com/samwelnyandoro/mpesaintegrationandroid-backend.git).
3. A model backend database schema
4. After payments, integration with Firebase Cloud Messaging makes it simple to deliver push alerts to the app.
5. You may quickly launch a complete sample application to see how the SDK works.
6. A free [hosted backend](https://mpesa.samwel.com) you can use for testing purposes.
7. This lovely README 😀

## Getting started
You will require the following from [Safaricom Developer dashboard](https://developer.safaricom.co.ke)
1. Your Consumer Key
2. Your Consumer Secret
3. The business shortcode
4. A Firebase project with a server key. Create one [here](https://console.firebase.google.com/)
For testing purposes, you can get test credentials [here](https://developer.safaricom.co.ke/test_credentials).
Use the *Lipa Na Mpesa Online Shortcode* and *Lipa Na Mpesa Online Passkey* from the link.
## Integrating with your app
1. Add the SDK to your project
    ```  implementation 'com.github.samwelnyandoro:MpesaIntegrationAndroid:v1.0.0'```
    
2. Initialize the SDK
    ```Mpesa.with(context, CONSUMER_KEY, CONSUMER_SECRET);```
    
    You can optionally pass the mode as the third parameter , either `SANDBOX` or `PRODUCTION`
      ```Mpesa.with(context, CONSUMER_KEY, CONSUMER_SECRET, Mode.PRODUCTION);```
3. Implement the `AuthListener` interface in your activity.The interface provides two methods
* ```public void onAuthError(Pair<Integer, String> result)```
    This method is called when initializing the Mpesa instance fails.You can get the response code using `result.code` and the error message using `result.message`. Make sure your credentials are correct
* ``` public void onAuthSuccess()``` 
    This method is called once the Mpesa instance initializes successfully.You can only make a successful transaction after this method is called.Therefore, you can use this method to update the user interface like enabling a disabled button.
## Making a transaction
Before making a transaction, your need to make sure you have the following items:
1. A business shortcode. For testing purposes , get one [here](https://developer.safaricom.co.ke/test_credentials).
2. A pass key. For testing, you can get one from the same link.
3. The amount to transact.
4. The phone number making the payment. It can be in 07xx.. or 254xx.. or +254xx... formats. The SDK will sanitize it for you.
    To make a transaction , you build an `STKPush` instance and pass it to `pay()` method
       ```STKPush.Builder builder = new Builder(BUSINESS_SHORT_CODE, PASSKEY, amount,BUSINESS_SHORT_CODE, phone);```
    
    ```STKPush push = builder.build();```
    
    ```Mpesa.getInstance().pay(context, push);```
5. Make sure your activity implements `MpesaListener`. The interface provides two methods you will need to implement
 * ```public void onMpesaError(Pair<Integer, String> result)```
 
    This method is called if the request could not be processed. You can get the error message generated by using `result.message`
 
 * ``` public void onMpesaSuccess(String MerchantRequestID, String CheckoutRequestID, String CustomerMessage)```
 
    When Safaricom receives the request and accepts it for processing, this function is invoked. A popup for the user to input their MPESA pin will appear.
 
Congrats! You completed an MPESA transaction successfully.
