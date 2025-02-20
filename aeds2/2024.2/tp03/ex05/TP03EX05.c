#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

typedef struct Date
{
    int day;
    int month;
    int year;
} Date;

char *dateToString(Date date)
{
    char *str = (char *)malloc(11 * sizeof(char));
    sprintf(str, "%02d/%02d/%04d", date.day, date.month, date.year);
    return str;
}

Date stringToDate(char *str)
{
    Date date;
    if (str != NULL && strlen(str) > 0)
    { // Verifica se str não é NULL e não está vazia
        sscanf(str, "%d/%d/%d", &date.day, &date.month, &date.year);
    }
    else
    {
        date.day = 0;
        date.month = 0;
        date.year = 0;
    }
    return date;
}

typedef struct Pokemon
{
    int id;
    int generation;
    char *name;
    char *description;
    char types[2][50];
    char abilities[6][50];
    double weight;
    double height;
    int captureRate;
    bool isLegendary;
    Date captureDate;
} Pokemon;

// strdup aloca memória para a string
char *my_strdup(const char *s)
{
    char *copy = (char *)malloc(strlen(s) + 1);

    if (copy != NULL)
    {
        strcpy(copy, s);
    }
    return copy;
}

// id
int getId(Pokemon *p)
{
    return p->id;
}

void setId(Pokemon *p, int id)
{
    p->id = id;
}

// generation
int getGeneration(Pokemon *p)
{
    return p->generation;
}

void setGeneration(Pokemon *p, int generation)
{
    p->generation = generation;
}

// name
char *getName(Pokemon *p)
{
    return p->name;
}

void setName(Pokemon *p, char *name)
{
    p->name = name;
}

// description
char *getDescription(Pokemon *p)
{
    return p->description;
}

void setDescription(Pokemon *p, char *description)
{
    p->description = description;
}

// types
char *getTypes(Pokemon *p, int index)
{
    return p->types[index];
}

int getNumTypes(Pokemon *p)
{
    int count = 0;
    for (int i = 0; i < 2; i++)
    {
        if (strlen(p->types[i]) > 0)
        {
            count++;
        }
    }
    return count;
}

void setTypes(Pokemon *p, int index, char *type)
{
    strncpy(p->types[index], type, sizeof(p->types[index]) - 1);
    p->types[index][sizeof(p->types[index]) - 1] = '\0';
}

// abilities
char *getAbilities(Pokemon *p, int index)
{
    return p->abilities[index];
}

int getNumAbilities(Pokemon *p)
{
    int count = 0;
    for (int i = 0; i < 6; i++)
    {
        if (strlen(p->abilities[i]) > 0)
        {
            count++;
        }
    }
    return count;
}

void setAbilities(Pokemon *p, int index, const char *ability)
{
    strncpy(p->abilities[index], ability, sizeof(p->abilities[index]) - 1);
    p->abilities[index][sizeof(p->abilities[index]) - 1] = '\0';
}

// weight
double getWeight(Pokemon *p)
{
    return p->weight;
}

void setWeight(Pokemon *p, double weight)
{
    p->weight = weight;
}

// height
double getHeight(Pokemon *p)
{
    return p->height;
}

void setHeight(Pokemon *p, double height)
{
    p->height = height;
}

// captureRate
int getCaptureRate(Pokemon *p)
{
    return p->captureRate;
}

void setCaptureRate(Pokemon *p, int captureRate)
{
    p->captureRate = captureRate;
}

// isLegendary
bool getIsLegendary(Pokemon *p)
{
    return p->isLegendary;
}

void setIsLegendary(Pokemon *p, bool isLegendary)
{
    p->isLegendary = isLegendary;
}

// captureDate
Date getCaptureDate(Pokemon *p)
{
    return p->captureDate;
}

void setCaptureDateDate(Pokemon *p, Date captureDate)
{
    p->captureDate = captureDate;
}

void setCaptureDateString(Pokemon *p, char *captureDate)
{
    p->captureDate = stringToDate(captureDate);
}

Pokemon *findPokemonById(Pokemon pokedex[], int n, int id)
{
    for (int i = 0; i < n; i++)
    {
        if (pokedex[i].id == id)
        {
            return &pokedex[i];
        }
    }
}

Pokemon createPokemon(int id, int generation, char *name,
                      char *description, char *type1, char *type2, char *abilities[6], double weight,
                      double height, int captureRate, bool isLegendary, Date captureDate)
{

    Pokemon p;

    setId(&p, id);
    setGeneration(&p, generation);

    char *nameCopy = my_strdup(name);
    char *descriptionCopy = my_strdup(description);

    setName(&p, nameCopy);
    setDescription(&p, descriptionCopy);

    // types
    setTypes(&p, 0, type1);
    if (type2 != NULL)
    {
        setTypes(&p, 1, type2);
    }

    // abilities
    for (int i = 0; i < 6; i++)
    {
        if (abilities[i] != NULL)
        {
            setAbilities(&p, i, abilities[i]);
        }
        else
        {
            strcpy(p.abilities[i], "");
        }
    }

    setWeight(&p, weight);
    setHeight(&p, height);
    setCaptureRate(&p, captureRate);
    setIsLegendary(&p, isLegendary);
    setCaptureDateDate(&p, captureDate);

    return p;
}

int split_csv_line(char *line, char **fields, int max_fields)
{
    int field_count = 0;
    char *ptr = line;
    int in_quotes = 0;
    char *field_start = ptr;

    while (*ptr && field_count < max_fields)
    {
        if (*ptr == '"')
        {
            in_quotes = !in_quotes;
        }
        else if (*ptr == ',' && !in_quotes)
        {
            *ptr = '\0';
            fields[field_count++] = field_start;
            field_start = ptr + 1;
        }
        ptr++;
    }
    if (field_count < max_fields)
    {
        fields[field_count++] = field_start;
    }

    return field_count;
}

void lerPokemon(FILE *file, Pokemon *pokedex, int *n)
{
    char line[1024];

    fgets(line, sizeof(line), file);

    while (fgets(line, sizeof(line), file) != NULL)
    {
        line[strcspn(line, "\n")] = '\0';

        Pokemon p;
        memset(&p, 0, sizeof(Pokemon));

        char *fields[12];
        int field_count = split_csv_line(line, fields, 12);

        // id
        p.id = atoi(fields[0]);

        // generation
        p.generation = atoi(fields[1]);

        // name
        p.name = my_strdup(fields[2]);

        // description
        p.description = my_strdup(fields[3]);

        // types
        setTypes(&p, 0, fields[4]);
        if (strlen(fields[5]) > 0)
        {
            setTypes(&p, 1, fields[5]);
        }
        else
        {
            strcpy(p.types[1], "");
        }

        char *abilities_field = fields[6];
        if (abilities_field[0] == '"' && abilities_field[strlen(abilities_field) - 1] == '"')
        {
            abilities_field[strlen(abilities_field) - 1] = '\0';
            abilities_field++;
        }
        if (abilities_field[0] == '[' && abilities_field[strlen(abilities_field) - 1] == ']')
        {
            abilities_field[strlen(abilities_field) - 1] = '\0';
            abilities_field++;
        }

        char *abilityToken;
        char *restAbilities = abilities_field;
        int abilityIndex = 0;
        while ((abilityToken = strtok_r(restAbilities, ",", &restAbilities)) && abilityIndex < 6)
        {
            while (*abilityToken == ' ' || *abilityToken == '\'')
                abilityToken++;
            char *tempEnd = abilityToken + strlen(abilityToken) - 1;
            while (tempEnd > abilityToken && (*tempEnd == ' ' || *tempEnd == '\''))
            {
                *tempEnd = '\0';
                tempEnd--;
            }
            if (strlen(abilityToken) > 0)
            {
                setAbilities(&p, abilityIndex, abilityToken);
                abilityIndex++;
            }
        }
        for (; abilityIndex < 6; abilityIndex++)
        {
            strcpy(p.abilities[abilityIndex], "");
        }

        p.weight = atof(fields[7]);

        p.height = atof(fields[8]);

        p.captureRate = atoi(fields[9]);

        p.isLegendary = atoi(fields[10]);

        p.captureDate = stringToDate(fields[11]);

        pokedex[*n] = p;
        (*n)++;
    }
}

void imprimirPokemon(Pokemon *p)
{
    printf("[#%d -> %s: %s - ['", getId(p), getName(p), getDescription(p));

    int numTypes = getNumTypes(p);
    if (numTypes > 0)
    {
        printf("%s", getTypes(p, 0));
    }
    if (numTypes > 1)
    {
        printf("', '%s", getTypes(p, 1));
    }
    printf("'] - ");

    int numAbilities = getNumAbilities(p);
    printf("[");
    for (int i = 0; i < numAbilities; i++)
    {
        printf("'%s'", getAbilities(p, i));
        if (i < numAbilities - 1)
        {
            printf(", ");
        }
    }
    printf("] - ");

    printf("%.1fkg - ", getWeight(p));
    printf("%.1fm - ", getHeight(p));
    printf("%d%% - ", getCaptureRate(p));
    printf("%s - ", getIsLegendary(p) ? "true" : "false");
    printf("%d gen] - ", getGeneration(p));
    char *data = dateToString(getCaptureDate(p));
    printf("%s", data);
    free(data);

    printf("\n");
}

// CELULA/LIST:
typedef struct Celula
{
    Pokemon *pokemon;
    struct Celula *prox;
} Celula;

Celula *novaCelula(Pokemon *pokemon)
{
    Celula *nova = (Celula *)malloc(sizeof(Celula));
    nova->pokemon = pokemon;
    nova->prox = NULL;
    return nova;
}

typedef struct Lista
{
    Celula *cabeca;
    int n;
} Lista;

void inicializarLista(Lista *lista)
{
    lista->cabeca = NULL;
    lista->n = 0;
}

void inserirInicio(Lista *lista, Pokemon *pokemon)
{
    Celula *nova = novaCelula(pokemon);
    nova->prox = lista->cabeca;
    lista->cabeca = nova;
    lista->n++;
}

void inserirFim(Lista *lista, Pokemon *pokemon)
{
    Celula *nova = novaCelula(pokemon);
    if (lista->cabeca == NULL)
    {
        // Lista vazia
        lista->cabeca = nova;
    }
    else
    {
        Celula *atual = lista->cabeca;
        while (atual->prox != NULL)
        {
            atual = atual->prox;
        }
        atual->prox = nova;
    }
    lista->n++;
}

void inserir(Lista *lista, Pokemon *pokemon, int pos)
{
    if (pos < 0 || pos > lista->n)
    {
        printf("posição invalida\n");
        return;
    }
    if (pos == 0)
    {
        inserirInicio(lista, pokemon);
    }
    else
    {
        Celula *nova = novaCelula(pokemon);
        Celula *atual = lista->cabeca;
        for (int i = 0; i < pos - 1; i++)
        {
            atual = atual->prox;
        }
        nova->prox = atual->prox;
        atual->prox = nova;
        lista->n++;
    }
}

Pokemon *removerInicio(Lista *lista)
{
    if (lista->cabeca == NULL)
    {
        printf("lista vazia\n");
        exit(EXIT_FAILURE);
    }
    Celula *removida = lista->cabeca;
    lista->cabeca = removida->prox;
    Pokemon *pokemonRemovido = removida->pokemon;
    free(removida);
    lista->n--;
    return pokemonRemovido;
}

Pokemon *removerFim(Lista *lista)
{
    if (lista->cabeca == NULL)
    {
        printf("lista vazia\n");
        exit(EXIT_FAILURE);
    }
    Celula *atual = lista->cabeca;
    Celula *anterior = NULL;
    while (atual->prox != NULL)
    {
        anterior = atual;
        atual = atual->prox;
    }
    Pokemon *pokemonRemovido = atual->pokemon;
    if (anterior == NULL)
    {
        lista->cabeca = NULL;
    }
    else
    {
        anterior->prox = NULL;
    }
    free(atual);
    lista->n--;
    return pokemonRemovido;
}

Pokemon *remover(Lista *lista, int pos)
{
    if (pos < 0 || pos >= lista->n || lista->cabeca == NULL)
    {
        printf("Erro\n");
        exit(EXIT_FAILURE);
    }
    if (pos == 0)
    {
        return removerInicio(lista);
    }
    else
    {
        Celula *atual = lista->cabeca;
        Celula *anterior = NULL;
        for (int i = 0; i < pos; i++)
        {
            anterior = atual;
            atual = atual->prox;
        }
        anterior->prox = atual->prox;
        Pokemon *pokemonRemovido = atual->pokemon;
        free(atual);
        lista->n--;
        return pokemonRemovido;
    }
}

void imprimirLista(Lista *lista)
{
    Celula *atual = lista->cabeca;
    int pos = 0;
    while (atual != NULL)
    {
        printf("[%d] ", pos);
        imprimirPokemon(atual->pokemon);
        atual = atual->prox;
        pos++;
    }
}

// main

int main()
{
    char *csvPath = "/tmp/pokemon.csv";

    FILE *file = fopen(csvPath, "r");

    if (file == NULL)
    {
        printf("erro\n");
        return 1;
    }

    Pokemon pokedex[801];
    int n = 0;

    lerPokemon(file, pokedex, &n);

    fclose(file);

    Lista pLista;
    inicializarLista(&pLista);

    char inputId[10];
    scanf("%s", inputId);

    while (strcmp(inputId, "FIM") != 0)
    {
        int id = atoi(inputId);
        Pokemon *p = findPokemonById(pokedex, n, id);
        if (p != NULL)
        {
            inserirFim(&pLista, p);
        }

        scanf("%s", inputId);
    }

    int qtdComandos;
    char comandos[3];
    scanf("%i", &qtdComandos);

    for (int i = 0; i < qtdComandos; i++)
    {
        scanf("%s", comandos);

        if (strcmp(comandos, "II") == 0)
        {
            scanf("%s", inputId);
            int id = atoi(inputId); // passa string para int
            Pokemon *p = findPokemonById(pokedex, n, id);
            if (p != NULL)
            {
                inserirInicio(&pLista, p);
            }
        }
        else if (strcmp(comandos, "I*") == 0)
        {
            int pos;
            scanf("%d", &pos);
            scanf("%s", inputId);
            int id = atoi(inputId); // passa string para int
            Pokemon *p = findPokemonById(pokedex, n, id);
            if (p != NULL)
            {
                inserir(&pLista, p, pos);
            }
        }
        else if (strcmp(comandos, "IF") == 0)
        {
            scanf("%s", inputId);
            int id = atoi(inputId); // passa string para int
            Pokemon *p = findPokemonById(pokedex, n, id);
            if (p != NULL)
            {
                inserirFim(&pLista, p);
            }
        }
        else if (strcmp(comandos, "RI") == 0)
        {
            Pokemon *p = removerInicio(&pLista);
            if (p != NULL)
            {
                printf("(R) %s\n", p->name);
            }
        }
        else if (strcmp(comandos, "R*") == 0)
        {
            int pos;
            scanf("%d", &pos);
            Pokemon *p = remover(&pLista, pos);
            if (p != NULL)
            {
                printf("(R) %s\n", p->name);
            }
        }
        else if (strcmp(comandos, "RF") == 0)
        {
            Pokemon *p = removerFim(&pLista);
            if (p != NULL)
            {
                printf("(R) %s\n", p->name);
            }
        }
    }

    imprimirLista(&pLista);
    return 0;
}