package helpers

import junit.framework.AssertionFailedError
import org.apache.commons.codec.digest.DigestUtils
import pages.Config

import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.Files
import java.io.File
import java.nio.file.StandardCopyOption

/**
 * Created by Kateryna on 24.12.2017.
 */
class DirectoryCreator {

     private static void createPlanDirectory() throws IOException {

         def path = Paths.get(Config.bambooHome, "xml-data", "build-dir").toString()
         final FileTreeBuilder treeBuilder = new FileTreeBuilder(new File(path))
         treeBuilder.dir("${Config.projKey}-${Config.planKey}-JOB1")
     }

     private static void copyFile(String fileName) {

         Files.copy(
                 new File(Paths.get(Config.testFiles).toString(), fileName).toPath(),
                 new File(Paths.get(Config.bambooHome, "xml-data", "build-dir", "${Config.projKey}-${Config.planKey}-JOB1", "my_test").toString()).toPath(),
                 StandardCopyOption.REPLACE_EXISTING,
                 StandardCopyOption.COPY_ATTRIBUTES
         )

         Files.copy(
                 new File(Paths.get(Config.testFiles).toString(), "libboost_unit_test_framework.so.1.58.0").toPath(),
                 new File(Paths.get(Config.bambooHome, "xml-data", "build-dir", "${Config.projKey}-${Config.planKey}-JOB1", "libboost_unit_test_framework.so.1.58.0").toString()).toPath(),
                 StandardCopyOption.REPLACE_EXISTING,
                 StandardCopyOption.COPY_ATTRIBUTES
         )
     }
}