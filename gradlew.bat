????   4@
    ? ? ? ? ?
  ?  ? ? ? ? ? ?  ? ? ? ?   ? ? ? ? ?  ? ? ?  ? ? ?  ? ?  ? ? ? ?
  ? ? ? ? ? ? ? ? ? ? ?
  ?
  ? ? ? ? ?  ? ? ?  ?  ? ? ? ? ? ?
 ? ?  ?
  ? ?
 ? ? ?
 4 ?
 4 ? ?
  ? ?  ?
  ? ? ?
  ?  ?
  ? ? ?
  ? 	 ?
  ? ? ? TASK_REPORT Ljava/lang/String; ConstantValue PROPERTY_REPORT DEPENDENCY_REPORT HTML_DEPENDENCY_REPORT PROJECT_REPORT <init> ()V Code LineNumberTable LocalVariableTable this -Lorg/gradle/api/plugins/ProjectReportsPlugin; apply (Lorg/gradle/api/Project;)V project Lorg/gradle/api/Project; 
convention 7Lorg/gradle/api/plugins/ProjectReportsPluginConvention; (Ljava/lang/Object;)V lambda$apply$8 (Lorg/gradle/api/Task;)V projectReportTask Lorg/gradle/api/Task; lambda$apply$7 ?(Lorg/gradle/api/Project;Lorg/gradle/api/plugins/ProjectReportsPluginConvention;Lorg/gradle/api/reporting/dependencies/HtmlDependencyReportTask;)V htmlDependencyReportTask @Lorg/gradle/api/reporting/dependencies/HtmlDependencyReportTask; lambda$apply$6 K(Lorg/gradle/api/plugins/ProjectReportsPluginConvention;)Ljava/lang/String; 
Exceptions ? lambda$apply$5 q(Lorg/gradle/api/plugins/ProjectReportsPluginConvention;Lorg/gradle/api/tasks/diagnostics/DependencyReportTask;)V dependencyReportTask 7Lorg/gradle/api/tasks/diagnostics/DependencyReportTask; lambda$apply$4 K(Lorg/gradle/api/plugins/ProjectReportsPluginConvention;)Ljava/lang/Object; lambda$apply$3 o(Lorg/gradle/api/plugins/ProjectReportsPluginConvention;Lorg/gradle/api/tasks/diagnostics/PropertyReportTask;)V propertyReportTask 5Lorg/gradle/api/tasks/diagnostics/PropertyReportTask; lambda$apply$2 lambda$apply$1 k(Lorg/gradle/api/plugins/ProjectReportsPluginConvention;Lorg/gradle/api/tasks/diagnostics/TaskReportTask;)V taskReportTask 1Lorg/gradle/api/tasks/diagnostics/TaskReportTask; lambda$apply$0 	Signature CLjava/lang/Object;Lorg/gradle/api/Plugin<Lorg/gradle/api/Project;>; 
SourceFile ProjectReportsPlugin.java Q R ? ? *org/gradle/api/plugins/ReportingBasePlugin ? X ? Eorg/gradle/api/plugins/internal/DefaultProjectReportsPluginConvention Q Y ? ? ? ? ? projectReports ? ? ? ? ? +org/gradle/api/plugins/ProjectReportsPlugin 
taskReport /org/gradle/api/tasks/diagnostics/TaskReportTask BootstrapMethods ? ^ ? ? ? ? ? ? ? propertyReport 3org/gradle/api/tasks/diagnostics/PropertyReportTask ? ? dependencyReport 5org/gradle/api/tasks/diagnostics/DependencyReportTask ? ? htmlDependencyReport >org/gradle/api/reporting/dependencies/HtmlDependencyReportTask ? ? ? ? projectReport ? ` ? ? ? ? org/gradle/api/Project X Y java/lang/Object ? ? ? &Generates