using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClassLibrary8
{
    public partial class SettingsForm : Form
    {
        public SettingsForm()
        {
            InitializeComponent();
        }

        private void SettingsForm_Load(object sender, EventArgs e)
        {
            this.SitUrlTextBox.Text = Settings1.Default["SitUrl"].ToString();
            this.SitFrontUrlTextBox.Text = Settings1.Default["SitFrontUrl"].ToString();
            this.SitUsernameTextBox.Text = Settings1.Default["username"].ToString();
            this.SitPasswordTextBox.Text = Settings1.Default["password"].ToString();

        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            Settings1.Default["SitUrl"] = this.SitUrlTextBox.Text;
            Settings1.Default["SitFrontUrl"] = this.SitFrontUrlTextBox.Text;
            Settings1.Default["username"] = this.SitUsernameTextBox.Text;
            Settings1.Default["password"] = this.SitPasswordTextBox.Text;


            Settings1.Default.Save();
            MessageBox.Show("Στοιχεία αποθηκεύτηκαν");
        }
    }
}
