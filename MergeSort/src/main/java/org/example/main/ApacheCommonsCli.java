package org.example.main;
import org.apache.commons.cli.*;
public class ApacheCommonsCli {

    //public static void main(String[] args) throws Exception {
      public static CommandLine getCmd(String[] args) {
          //ApacheCommonsCli_01.getSum(String[] args);
          Options options = new Options();

          Option integerFilesOpt = new Option("i", "integer", true, "integer file path");
          //integerFilesOpt.setRequired(false);
          integerFilesOpt.setArgs(Option.UNLIMITED_VALUES);
          integerFilesOpt.setOptionalArg(true);
          integerFilesOpt.setValueSeparator(',');
          //options.addOption(integerFilesOpt);

          Option stringFilesOpt = new Option("s", "string", true, "string file path");
          //stringFilesOpt.setRequired(false);
          stringFilesOpt.setArgs(Option.UNLIMITED_VALUES);
          stringFilesOpt.setOptionalArg(true);
          stringFilesOpt.setValueSeparator(',');
          //options.addOption(stringFilesOpt);

          OptionGroup fileTypeOptGroup = new OptionGroup();
          fileTypeOptGroup.setRequired(true);
          //fileTypeOptGroup.addOption(new Option("i", true, "integer file path"));
          //fileTypeOptGroup.addOption(new Option("s", true, "string file path"));
          fileTypeOptGroup.addOption(integerFilesOpt);
          fileTypeOptGroup.addOption(stringFilesOpt);
          options.addOptionGroup(fileTypeOptGroup);


          Option outputOpt = new Option("o", "output", true, "output file path");
          outputOpt.setRequired(true);
          outputOpt.setOptionalArg(true);
          options.addOption(outputOpt);


          Option ascSortOpt = new Option("a", "ascending", false, "ascending sort");
          ascSortOpt.setRequired(false);
          ascSortOpt.setArgs(0);
          ascSortOpt.setOptionalArg(false);
          options.addOption(ascSortOpt);

          Option desSortOpt = new Option("d", "descending", false, "descending sort");
          desSortOpt.setRequired(false);
          desSortOpt.setArgs(0);
          desSortOpt.setOptionalArg(false);
          options.addOption(desSortOpt);

          OptionGroup sortTypeOptGroup = new OptionGroup();
          sortTypeOptGroup.setRequired(false);
          //sortTypeOptGroup.addOption(new Option("i", true, "integer file path"));
          //sortTypeOptGroup.addOption(new Option("s", true, "string file path"));
          sortTypeOptGroup.addOption(ascSortOpt);
          sortTypeOptGroup.addOption(desSortOpt);
          options.addOptionGroup(sortTypeOptGroup);


          CommandLineParser parser = new DefaultParser();
          HelpFormatter formatter = new HelpFormatter();
          CommandLine cmd = null;//not a good practice, it serves it purpose
          try {
              cmd = parser.parse(options, args);
          } catch (ParseException e) {
              System.out.println(e.getMessage());
              formatter.printHelp("utility-name", options);
              System.exit(1);
          }

          return cmd;
      }



    public static String[] getFilePaths(CommandLine cmd) {
          if(cmd.hasOption("i")) {
              String[] integerFilePath = cmd.getOptionValues("i");
              return integerFilePath;
          } else {
              String[] stringFilePath = cmd.getOptionValues("s");
              return stringFilePath;
          }
    }


    public static String getOutFilePath(CommandLine cmd) {
        String outputFilePath = cmd.getOptionValue("output");
        System.out.println("Output " + outputFilePath);
        return outputFilePath;
    }


    //public static String getSortType(CommandLine cmd) {
      public static Boolean getSortType(CommandLine cmd) {
        String sort;
        if (cmd.hasOption("d")) {
            return false;
        } else {
            return true;
        }
    }




}
