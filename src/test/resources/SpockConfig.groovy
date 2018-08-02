spockReports {

    set( ['com.athaydes.spockframework.report.outputDir': 'build/reports/geb-spock-reports',
          'com.athaydes.spockframework.report.IReportCreator': 'com.athaydes.spockframework.report.template.TemplateReportCreator',
          'com.athaydes.spockframework.report.showCodeBlocks': true,
          'com.athaydes.spockframework.report.template.TemplateReportCreator.specTemplateFile':'/templates/spec-template.html',
          'com.athaydes.spockframework.report.template.TemplateReportCreator.reportFileExtension':'html',
          'com.athaydes.spockframework.report.template.TemplateReportCreator.summaryTemplateFile':'/templates/summary-template.html',
          'com.athaydes.spockframework.report.template.TemplateReportCreator.summaryFileName':'index.html'

    ] )

}