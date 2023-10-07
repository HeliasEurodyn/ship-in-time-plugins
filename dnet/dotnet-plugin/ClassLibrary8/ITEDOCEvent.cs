using Softone;
using System.Collections.Generic;
using System.Diagnostics;
using System.Text;
using System.Windows.Forms;
using System;

namespace ClassLibrary8
{
    [WorksOn("ITEDOC")]
    internal class ITEDOCEvent : TXCode
    {
        public override void Initialize()
        {

        }

        public override object ExecCommand(int Cmd)
        {
            XTable ITEDOCTbl = XModule.GetTable("ITEDOC");
            
            switch (Cmd)
            {
                case 150002:
                    
                    String sql =
                       @" SELECT  F.FINDOC, SUM(ML.QTY1) AS QTY, CONVERT(VARCHAR(33), F.TRNDATE, 126)+ 'Z' AS TRNDATE, B.ZIP AS SHIPING_FROM, MD.SHPZIP AS SHIPING_TO, FF.UFTBL01 AS TRUCK
                            FROM MTRLINES ML
                            INNER JOIN FINDOC F ON F.FINDOC = ML.FINDOC
                            INNER JOIN FINDOC FF ON FF.FINDOC = ML.CCCNPRELFINDOC
                            INNER JOIN MTRDOC MD ON MD.FINDOC = FF.FINDOC
                            INNER JOIN BRANCH B ON B.BRANCH = FF.BRANCH
                            WHERE ML.FINDOC = " + ITEDOCTbl.Current["FINDOC"].ToString() +
                        @" AND ML.MTRUNIT = 151
                           GROUP BY F.TRNDATE, B.ZIP , MD.SHPZIP, F.FINDOC, FF.UFTBL01 ";

                    XTable DATASql = XSupport.GetSQLDataSet(sql);

                    var routesDTO = new List<Dictionary<string, string>>();

                    if (DATASql.Count == 0) {
                        MessageBox.Show("Η διαδικασία δεν μπορεί να ολοκληρωθεί!");
                        break;
                    }

                        if (DATASql.Count > 1)
                    for (int i = 0; i < DATASql.Count; i++)
                    {
                        var routeDTO = new Dictionary<string, string>
                        {
                            { "to", DATASql[i, "SHIPING_TO"].ToString() }
                        };
                        routesDTO.Add(routeDTO);
                    }

                    var shipingProductDTO = new Dictionary<string, object>
                        {
                            { "id", DATASql[0, "FINDOC"].ToString() },
                            { "qty", DATASql[0, "QTY"] },
                            { "trndate", DATASql[0, "TRNDATE"].ToString()},
                            { "from", DATASql[0, "SHIPING_FROM"].ToString() },
                            { "to", DATASql[0, "SHIPING_TO"].ToString() },
                            { "truck", DATASql[0, "TRUCK"].ToString() },
                            { "routes", routesDTO }
                        };

                    try
                    {
                        String accessToken = ShipInTimeRestCalls.GetAccessToken().GetAwaiter().GetResult();
                        ShipInTimeRestCalls.RegisterNewShipingProduct(shipingProductDTO, accessToken).GetAwaiter().GetResult();

                        XSupport.ExecuteSQL("UPDATE FINDOC SET CCCONAPP = 1 WHERE FINDOC = " + ITEDOCTbl.Current["FINDOC"].ToString());
                        //ITEDOCTbl.Current["CCCONAPP"] = 1;
                        MessageBox.Show("H Διαδικασία ολοκληρώθηκε!");
                    }
                    catch (Exception ex)
                    {
                        Console.WriteLine("An error occurred: " + ex.Message);
                    }

                    break;

                case 150003:

                    String accessTkn = ShipInTimeRestCalls.GetAccessToken().GetAwaiter().GetResult();
                    String s1Id = ShipInTimeRestCalls.getId(ITEDOCTbl.Current["FINDOC"].ToString(), accessTkn).GetAwaiter().GetResult();

                    if (s1Id.Equals("")) {
                        MessageBox.Show("Το Δρομολόγιο δεν υπάρχει στο Ship In Time!");
                        break;
                    }

                    string inputString = "{\"COMMAND-TYPE\":\"FORM\",\"LOCATE\":{\"ID\":\"748a73ec-28a1-4985-b203-84ab52717335\",\"SELECTION-ID\":\"" + s1Id + "\"}}";
                    byte[] inputBytes = Encoding.UTF8.GetBytes(inputString);
                    string base64String = Convert.ToBase64String(inputBytes);
                    String url = Settings1.Default["SitFrontUrl"].ToString()+"/form?nav=" + base64String;
                    Process.Start(url);

                    break;



            }
            return base.ExecCommand(Cmd);
        }
    }
}
