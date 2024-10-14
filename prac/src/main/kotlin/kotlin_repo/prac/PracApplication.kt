package kotlin_repo.prac

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.sql.Time
import java.util.TimeZone

@SpringBootApplication
class PracApplication

fun main(args: Array<String>) {
	TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"))
	runApplication<PracApplication>(*args)
}
