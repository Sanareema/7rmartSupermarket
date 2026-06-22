package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {//mult testcase should not collide/overlap, so synchronization is given
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");//LOCATION OF THE HTML REP TO BE GENERATED,./-directory,extent-reports-folder
		reporter.config().setReportName("7rmartSupermarket");//config().setReportName("7rmartproject") 2 methods in ExtentSparkReporter
		extentReports.attachReporter(reporter); // attaching extend report and extendssparkrep for report generation
		extentReports.setSystemInfo("Organization", "Obsqura"); // org name
		extentReports.setSystemInfo("Name", "Varsha");// team members name. We can add any no.of info
		//extentReports.setSystemInfo("Name", "Reema");
		return extentReports; // createExtentReports() returns extentReports
	}

}
