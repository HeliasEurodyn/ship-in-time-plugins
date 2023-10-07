using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;


namespace ClassLibrary8
{
    internal class ShipInTimeRestCalls
    {

        public ShipInTimeRestCalls() { }

       public static async Task<string> GetAccessToken()
        {

            var requestBody = new Dictionary<string, string>
                        {
                            { "username", Settings1.Default["username"].ToString() },
                            { "password", Settings1.Default["password"].ToString() }
                        };

            ServicePointManager.SecurityProtocol = SecurityProtocolType.Tls12;

            using (HttpClient client = new HttpClient())
            {
                var jsonBody = new StringContent(
                     JsonConvert.SerializeObject(requestBody),
                     Encoding.UTF8,
                     "application/json"
                 );

                var response = await client.PostAsync(Settings1.Default["SitUrl"].ToString() + "/user/auth", jsonBody);

                if (response.StatusCode == HttpStatusCode.OK)
                {
                    // Response as a dictionary
                    var responseContent = await response.Content.ReadAsStringAsync();
                    var jsonResponse = JsonConvert.DeserializeObject<Dictionary<string, Object>>(responseContent);

                    return (string)jsonResponse["accessToken"];
                }
                else
                {
                    throw new Exception("Request failed with status code: " + response.StatusCode);
                }
            }
        }


        public static async Task<string> RegisterNewUser(Dictionary<string, string> requestBody, String accessToken)
        {
            using (HttpClient client = new HttpClient())
            {

                client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", accessToken);


                var jsonBody = new StringContent(
                     JsonConvert.SerializeObject(requestBody),
                     Encoding.UTF8,
                     "application/json"
                 );

                var response = await client.PostAsync(Settings1.Default["SitUrl"].ToString() + "/s1-user/register", jsonBody);

                if (response.StatusCode == HttpStatusCode.OK)
                {
                    // Response as a dictionary
                    //  var responseContent = await response.Content.ReadAsStringAsync();
                    //  var jsonResponse = JsonConvert.DeserializeObject<Dictionary<string, Object>>(responseContent);

                    //   return (string)jsonResponse["accessToken"];
                    return "ok";
                }
                else
                {
                    throw new Exception("Request failed with status code: " + response.StatusCode);
                }
            }
        }

        public static async Task<string> RegisterNewShipingProduct(Dictionary<string, object> requestBody, String accessToken)
        {
            using (HttpClient client = new HttpClient())
            {

                client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", accessToken);


                var jsonBody = new StringContent(
                     JsonConvert.SerializeObject(requestBody),
                     Encoding.UTF8,
                     "application/json"
                 );

                var response = await client.PostAsync(Settings1.Default["SitUrl"].ToString() + "/s1-shiping-product/register", jsonBody);

                if (response.StatusCode == HttpStatusCode.OK)
                {
                    return "ok";
                }
                else
                {
                    throw new Exception("Request failed with status code: " + response.StatusCode);
                }
            }
        }

        public static async Task<string> getId(String id, String accessToken)
        {
            using (HttpClient client = new HttpClient())
            {

                client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", accessToken);


      
                var response = await client.GetAsync(Settings1.Default["SitUrl"].ToString() + "/s1-shiping-product/get-id-by-s1-id?id=" + id);

                if (response.StatusCode == HttpStatusCode.OK)
                {
                    var responseContent = await response.Content.ReadAsStringAsync();
                    var jsonResponse = JsonConvert.DeserializeObject<Dictionary<string, Object>>(responseContent);

                    return (string)jsonResponse["id"];
                }
                else
                {
                    throw new Exception("Request failed with status code: " + response.StatusCode);
                }
            }
        }


    }
}
