package ru.lemaitre.mythirdrecycleview

import kotlin.random.Random

class CelebrityRepository {
    fun generateCelebrities(count: Int): List<Celebrity> {
        val avatars = listOf(
            "https://pbs.twimg.com/profile_images/707293115699339264/CQ_zpgKU.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2wBYtm7nrueyPgNVcGkeXNdw62C9MDaQMSuXk4bZuK5ajAzdM&s",
            "data:image/jpeg;base64,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",
            "https://pbs.twimg.com/profile_images/641894324427427840/72XtBFDr.jpg"
        )
        val names = listOf(
            "Иван Петров",
            "Сергей Пупкин",
            "Андрей Машкин",
            "Виктор Чапаев",
            "Сергей Ярошевич",
            "Сергей Барсков",
            "Василий Новохатский"
        )
        val careers = listOf(
            "Актер",
            "Спортсмен"
        )
        val salaries = listOf(
            1232,
            232,
            21,
            18,
            500,
            300,
            10
        )
        return (0..count).map {
            val id = it.toLong()
            val name = names.random()
            val avatar = avatars.random()
            val salary = salaries.random()
            val career = careers.random()

            if (career == "Актер") {
                Celebrity.Actor(
                    id = id,
                    name = name,
                    avatarLink = avatar,
                    career = "Актер",
                    salary = salary,
                    icon = R.drawable.ic_actor
                )
            } else {
                Celebrity.Sportsman(
                    id = id,
                    name = name,
                    avatarLink = avatar,
                    career = "Спортсмен",
                    salary = salary,
                    icon = R.drawable.ic_rowling
                )
            }
        }
    }

    fun createCelebrity(celebrities: List<Celebrity>): List<Celebrity> {
        val newCelebrity = generateCelebrities(1).first().let {
            when (it) {
                is Celebrity.Actor -> it.copy(id = Random.nextLong())
                is Celebrity.Sportsman -> it.copy(id = Random.nextLong())
            }
        }
        return listOf(newCelebrity) + celebrities
    }

    fun deleteCelebrity(celebrities: List<Celebrity>, position: Int): List<Celebrity> {
        return celebrities.filterIndexed { index, celebrity -> index != position }
    }
}