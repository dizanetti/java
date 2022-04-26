package com.labmonitorfolder.config;

import com.labmonitorfolder.usecase.MyFileChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.devtools.filewatch.FileSystemWatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.io.File;
import java.time.Duration;

@Slf4j
@Configuration
public class FileWatcherConfig {

    @Value("${fileSystemWatcher.path}")
    private String path;

    @Bean
    public FileSystemWatcher fileSystemWatcher() {
        FileSystemWatcher fileSystemWatcher = new FileSystemWatcher(true,
                Duration.ofMillis(5000L),
                Duration.ofMillis(3000L));

        File file = new File(path);

        fileSystemWatcher.addSourceDirectory(file);
        fileSystemWatcher.addListener(new MyFileChangeListener());
        fileSystemWatcher.start();

        log.info("started fileSystemWatcher");

        return fileSystemWatcher;
    }

    @PreDestroy
    public void onDestroy() {
        fileSystemWatcher().stop();
    }
}
