TEMPLATE_RECIPE_RIGHT = """
{
    "type": "minecraft:crafting_shaped",
    "pattern": [
        "M ",
        "sM",
        "s "
    ],
    "key": {
        "s": {
            "item": "minecraft:stick"
        },
        "M": {
            "item": "minecraft:[MATERIAL]"
        }
    },
    "result": {
        "item": "better-food:[MATERIAL]_homi"
    }
}
"""

TEMPLATE_RECIPE_LEFT = """
{
    "type": "minecraft:crafting_shaped",
    "pattern": [
        " M",
        "Ms",
        " s"
    ],
    "key": {
        "s": {
            "item": "minecraft:stick"
        },
        "M": {
            "item": "minecraft:[MATERIAL]"
        }
    },
    "result": {
        "item": "better-food:[MATERIAL]_homi"
    }
}
"""

TO_REPLACE = '[MATERIAL]'

def generate_recipe(material_name):

    new_recipe_right = open(f'{material_name}_homi_right.txt', 'w')
    new_recipe_right.write(TEMPLATE_RECIPE_RIGHT.replace(TO_REPLACE, material_name))
    new_recipe_right.close()

    new_recipe_left = open(f'{material_name}_homi_left.txt', 'w')
    new_recipe_left.write(TEMPLATE_RECIPE_LEFT.replace(TO_REPLACE, material_name))
    new_recipe_left.close()

if __name__ == '__maine__':
    generate_recipe('iron')
    generate_recipe('diamond')
    generate_recipe('netherrite')
