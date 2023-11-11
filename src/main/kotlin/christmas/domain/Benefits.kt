package christmas.domain

class Benefits(private val benefits: List<Benefit>) {
    override fun toString(): String = benefits.joinToString("\n")
}