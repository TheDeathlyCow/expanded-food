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
        "item": "better-food:[TYPE]_homi"
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
        "item": "better-food:[TYPE]_homi"
    }
}
"""



def generate_recipe(type_name):

    material_line = '[MATERIAL]'

    material_name = type_name
    if type_name == 'golden':
        material_name = 'gold_ingot'
    elif type_name == 'iron':
        material_name = 'iron_ingot'
    elif type_name == 'wooden':
        material_line = '"item": "minecraft:[MATERIAL]"'
        material_name = '"tag": "minecraft:planks'
    elif type_name == 'stone':
        material_line = '"item": "minecraft:[MATERIAL]"'
        material_name = '"tag": "minecraft:stone_tool_materials"'

    new_recipe_right = open(f'{type_name}_homi_right.json', 'w+')
    new_recipe_right.write(TEMPLATE_RECIPE_RIGHT.replace(material_line, material_name).replace('[TYPE]', type_name))
    new_recipe_right.close()

    new_recipe_left = open(f'{type_name}_homi_left.json', 'w+')
    new_recipe_left.write(TEMPLATE_RECIPE_LEFT.replace(material_line, material_name).replace('[TYPE]', type_name))
    new_recipe_left.close()

if __name__ == '__main__':
    generate_recipe('wooden')
    generate_recipe('stone')
    generate_recipe('iron')
    generate_recipe('diamond')
    generate_recipe('golden')
    generate_recipe('netherrite')
