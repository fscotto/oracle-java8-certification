package com.oracle.java8.professional;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NIOTest {

    public static void main(String[] args) throws Exception {
        doUsingPathTest();
        doUsingAttributesTest();
        doUsingPosixAttributesTest();
        doUsingFileSystemVisitorTest();
        doUsingPathMatcherTest();
    }

    private static void doUsingPathTest() throws IOException {
        Path path = Paths.get("file.txt");
        boolean exists = Files.exists(path);
        System.out.println(exists);
        if (exists) {
            Files.delete(path);
        }

        Files.createFile(path);
        System.out.println(Files.exists(path));

        Path path2 = Paths.get("/home/plague/casa");
        System.out.println("getFileName(): " + path2.getFileName());
        System.out.println("getName(1): " + path2.getName(1));
        System.out.println("getNameCount(): " + path2.getNameCount());
        System.out.println("getParent(): " + path2.getParent());
        System.out.println("getRoot(): " + path2.getRoot());
        System.out.println("subpath(0, 2): " + path2.subpath(0, 2));
        System.out.println("toString(): " + path2.toString());

        int indentazione = 2;
        Path myPath = Paths.get("myDir", "subdir1", "subdir2", "test.txt");
        for (Path scendi : myPath) {
            System.out.format("%" + indentazione + "s%s%n", "", scendi);
            indentazione += 2;
        }
    }

    private static void doUsingAttributesTest() throws IOException {
        Path path = Paths.get("file.txt");
        BasicFileAttributes bfa = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("Data creazione: " + bfa.creationTime());
        System.out.println("Data ultimo accesso: " + bfa.lastAccessTime());
        System.out.println("Data ultima modifica: " + bfa.lastModifiedTime());
        System.out.println("E' una directory? " + bfa.isDirectory());

        FileTime dataUltimaModifica = bfa.lastModifiedTime();
        FileTime dataCreazione = bfa.creationTime();
        FileTime ora = FileTime.fromMillis(System.currentTimeMillis());

        BasicFileAttributeView bfaView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        bfaView.setTimes(dataUltimaModifica, ora, dataCreazione);
    }

    private static void doUsingPosixAttributesTest() throws IOException {
        Path passwd = Paths.get("/home/plague/Documenti/passwd.gpg");
        PosixFileAttributes pfa = Files.readAttributes(passwd, PosixFileAttributes.class);
        Set<PosixFilePermission> permessi = PosixFilePermissions.fromString("rw-r--r--");
        Files.setPosixFilePermissions(passwd, permessi);
        System.out.println(pfa.permissions());
        System.out.println(pfa.group());
    }

    private static void doUsingFileSystemVisitorTest() throws IOException {
        Path dir = Paths.get("/home/plague");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir, "*[aeiou]")) {
            System.out.println("[");
            for (Path p : directoryStream) {
                System.out.println(p.getFileName());
            }
            System.out.println("]");
        }

        Path path = Paths.get("file.txt");
        try (Stream<Path> stream = Files.walk(Paths.get("/home/plague/exercism"), FileVisitOption.FOLLOW_LINKS);
            PrintWriter pw = new PrintWriter(path.toFile())) {
            for (Path p : stream.collect(Collectors.toList())) {
                pw.println(p.toString());
            }
        }
    }

    private static void doUsingPathMatcherTest() {
        Path p1 = Paths.get("/home/myfile.txt");
        Path p2 = Paths.get("myfile.txt");
        matches(p1, "glob:*.txt");
        matches(p2, "glob:*.txt");
    }

    private static void matches(Path path, String glob) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(matcher.matches(path));
    }
}