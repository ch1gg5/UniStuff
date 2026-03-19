# hello-world.py
# Module: Example Module (XXX000)
# Topic:  Getting Started
# -------------------------------------------------------
# PURPOSE:
#   This file is a template showing the annotation style
#   used throughout the Practical-Lecture-Notes folder.
#   Each code file should:
#     1. State which module and topic it belongs to.
#     2. Explain WHAT the code does in plain English.
#     3. Add inline comments on any non-obvious lines.
# -------------------------------------------------------

def greet(name: str) -> str:
    """
    Build a greeting string for the given name.

    Args:
        name: The name of the person to greet.

    Returns:
        A formatted greeting string.
    """
    # f-strings (formatted string literals) embed variables
    # directly inside curly braces {} within a string.
    return f"Hello, {name}! Welcome to Loughborough University."


if __name__ == "__main__":
    # __name__ equals "__main__" only when this file is run
    # directly (not when it is imported as a module).
    message = greet("World")
    print(message)  # Output: Hello, World! Welcome to Loughborough University.
